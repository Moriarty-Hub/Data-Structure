package example.chapter01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordPuzzle {

    private final char[][] puzzle;
    private final int row;
    private final int column;
    private Set<String> wordList;
    private List<String> dictionary;

    private static final String DICTIONARY_FILENAME = "src/data/dictionary.txt";


    public WordPuzzle(char[][] puzzle) {
        this.puzzle = puzzle;
        row = puzzle.length;
        column = puzzle[0].length;
        wordList = new HashSet<>();
        dictionary = new LinkedList<>();
        loadDictionaryFile();
    }

    public void loadDictionaryFile(){
        File file = new File(DICTIONARY_FILENAME);
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                dictionary.add(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load dictionary file");
            System.exit(-1);
        }
    }

    public Set<String> getWordList() {
        findWordFromPuzzle();
        return wordList;
    }

    private void findWordFromPuzzle() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                checkSingleSquare(i, j);
            }
        }
    }

    private void checkSingleSquare(int row, int column) {
        searchUp(row, column);
        searchDown(row, column);
        searchLeft(row, column);
        searchRight(row, column);
        searchTopLeft(row, column);
        searchTopRight(row, column);
        searchBottomLeft(row, column);
        searchBottomRight(row, column);
    }

    private void searchUp(int startRow, int startColumn) {
        int endRow = startRow;
        StringBuilder word = new StringBuilder();
        while(endRow != -1) {
            word.append(puzzle[endRow][startColumn]);
            if (isWordExist(word.toString())) {
                wordList.add(word.toString());
            }
            endRow--;
        }
    }

    private void searchDown(int startRow, int startColumn) {
        int endRow = startRow;
        StringBuilder word = new StringBuilder();
        while(endRow != row) {
            word.append(puzzle[endRow][startColumn]);
            if (isWordExist(word.toString())) {
                wordList.add(word.toString());
            }
            endRow++;
        }
    }

    private void searchLeft(int startRow, int startColumn) {

    }

    private void searchRight(int startRow, int startColumn) {

    }

    private void searchTopLeft(int startRow, int startColumn) {

    }

    private void searchTopRight(int startRow, int startColumn) {

    }

    private void searchBottomLeft(int startRow, int startColumn) {

    }

    private void searchBottomRight(int startRow, int startColumn) {

    }

    private boolean isWordExist(String word) {
        return dictionary.contains(word);
    }

}

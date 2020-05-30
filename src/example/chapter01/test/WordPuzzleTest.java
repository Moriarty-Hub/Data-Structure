package example.chapter01.test;

import example.chapter01.WordPuzzle;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordPuzzleTest {

    @Test
    public void test1WordPuzzle() {
        char[][] sampleWordPuzzle1 = {{'t', 'h', 'i', 's'},
                                      {'w', 'a', 't', 's'},
                                      {'o', 'a', 'h', 'g'},
                                      {'f', 'g', 'd', 't'}};
        String[] sampleAnswer1 = {"a", "at", "of", "it", "hat", "this", "two", "fat", "that"};
        testSearch(sampleWordPuzzle1, sampleAnswer1);
    }

    private void testSearch(char[][] inputWordPuzzle, String[] expectedWordList) {
        WordPuzzle wordPuzzle = new WordPuzzle(inputWordPuzzle);
        Set<String> outputWordList = wordPuzzle.getWordList();

        assertEquals(expectedWordList.length, outputWordList.size());

        for (String word : expectedWordList) {
           assertTrue(outputWordList.contains(word));
        }
    }

    @Test
    public void test1SearchUp() {
        char[][] inputWordPuzzle = {{'t'}, {'a'}, {'h'}, {'t'}};
        String[] expectedWordList = {"a", "at", "hat", "that"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchUp() {
        char[][] inputWordPuzzle = {{'h'}, {'g'}, {'u'}, {'o'}, {'h'}, {'t'}, {'l'}, {'a'}};
        String[] expectedWordList = {"though", "a", "although"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchDown() {
        char[][] inputWordPuzzle = {{'l'}, {'a'}, {'n'}, {'g'}, {'u'}, {'a'}, {'g'}, {'e'}};
        String[] expectedWordList = {"language", "a", "age"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchDown() {
        char[][] inputWordPuzzle = {{'f'}, {'a'}, {'c'}, {'t'}, {'s'}};
        String[] expectedWordList = {"fact", "a", "act"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchLeft() {
        char[][] inputWordPuzzle = {{'n', 't', 'n', 'u', 'o', 'm', 'a', 'l'}};
        String[] expectedWordList = {"mount", "a", "amount"};
        testSearch(inputWordPuzzle, expectedWordList);

    }

    @Test
    public void test2SearchLeft() {
        char[][] inputWordPuzzle = {{'r', 'e', 'm', 'r', 'a', 'f'}};
        String[] expectedWordList = {"a", "arm", "far", "farm", "farmer"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchRight() {
        char[][] inputWordPuzzle = {{'o', 'f', 'f', 'i', 'c', 'e', 'r'}};
        String[] expectedWordList = {"of", "off", "office", "officer", "ice"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchRight() {
        char[][] inputWordPuzzle = {{'b', 'd', 'f', 'g', 'h'}};
        String[] expectedWordList = {};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchTopLeft() {
        char[][] inputWordPuzzle = {{'#', '#', '#', '#', '#', '#'},
                                    {'s', '#', '#', '#', '#', '#'},
                                    {'#', 'e', '#', '#', '#', '#'},
                                    {'#', '#', 'c', '#', '#', '#'},
                                    {'#', '#', '#', 'a', '#', '#'},
                                    {'#', '#', '#', '#', 'p', '#'},
                                    {'#', '#', '#', '#', '#', 's'},
                                    {'#', '#', '#', '#', '#', '#'}};
        String[] expectedWordList = {"a", "space", "pace"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchTopLeft() {
        char[][] inputWordPuzzle = {{'e', '#', '#'},
                                    {'#', 'c', '#'},
                                    {'#', '#', 'i'}};
        String[] expectedWordList = {"ice"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchTopRight() {
        char[][] inputWordPuzzle = {{'#', '#', '#', 'e'},
                                    {'#', '#', 't', '#'},
                                    {'#', 'a', '#', '#'},
                                    {'d', '#', '#', '#'}};
        String[] expectedWordList = {"a", "at", "ate", "date"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchTopRight() {
        char[][] inputWordPuzzle = {{'#', '#', '#', 'd'},
                                    {'#', '#', 'n', '#'},
                                    {'#', 'e', '#', '#'},
                                    {'s', '#', '#', '#'}};
        String[] expectedWordList = {"end", "send"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchBottomLeft() {
        char[][] inputWordPuzzle = {{'#', '#', '#', '#', '#', 's'},
                                    {'#', '#', '#', '#', 'e', '#'},
                                    {'#', '#', '#', 'a', '#', '#'},
                                    {'#', '#', 'r', '#', '#', '#'},
                                    {'#', 'c', '#', '#', '#', '#'},
                                    {'h', '#', '#', '#', '#', '#'}};
        String[] expectedWordList = {"sea", "search", "ear", "a"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test2SearchBottomLeft() {
        char[][] inputWordPuzzle = {{'#', '#', '#', 'p'},
                                    {'#', '#', 'a', '#'},
                                    {'#', 's', '#', '#'},
                                    {'s', '#', '#', '#'}};
        String[] expectedWordList = {"pass", "a", "as"};
        testSearch(inputWordPuzzle, expectedWordList);
    }

    @Test
    public void test1SearchBottomRight() {
        char[][] inputWordPuzzle = {{'m', '#', '#', '#', '#', '#'},
                                    {'#', 'o', '#', '#', '#', '#'},
                                    {'#', '#', 'n', '#', '#', '#'},
                                    {'#', '#', '#', 'd', '#', '#'},
                                    {'#', '#', '#', '#', 'a', '#'},
                                    {'#', '#', '#', '#', '#', 'y'}};
        String[] expectedWordPuzzle = {"monday", "on", "day", "a"};
        testSearch(inputWordPuzzle, expectedWordPuzzle);
    }

    @Test
    public void test2SearchBottomRight() {
        char[][] inputWordPuzzle = {{'e', '#', '#', '#'},
                                    {'#', 'x', '#', '#'},
                                    {'#', '#', 'i', '#'},
                                    {'#', '#', '#', 't'}};
        String[] expectedWordPuzzle = {"exit", "it"};
        testSearch(inputWordPuzzle, expectedWordPuzzle);
    }
}

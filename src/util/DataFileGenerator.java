package util;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *   This class is used for generating file that includes specified amount of random numbers. It can also read a random
 * number file, sort all numbers within it, and export them to a new file.
 *
 *   The main purpose of this class is generating some data for test cases.
 */
public class DataFileGenerator {

    private static final String ROOT_DIRECTORY = "src/data/";

    private static void generateRandomNumberFile(String filename, int amountOfNumbers) throws FileNotFoundException {
        File file = new File(ROOT_DIRECTORY + filename);
        PrintWriter printWriter = new PrintWriter(file);

        Random random = new Random();
        for (int i = 0; i < amountOfNumbers; i++) {
            printWriter.println(random.nextInt());
        }

        printWriter.close();
    }

    private static void generateSortedNumberFile(String filename, int amountOfNumbers) throws FileNotFoundException {

        int[] numbers = new int[amountOfNumbers];
        File file = new File(ROOT_DIRECTORY + filename);
        Scanner in = new Scanner(file);

        for (int i = 0; i < amountOfNumbers; i++) {
            numbers[i] = in.nextInt();
        }

        Arrays.sort(numbers);

        String outputFileName = filename.split("\\.")[0] + "-sorted." + filename.split("\\.")[1];

        File outputFile = new File(ROOT_DIRECTORY + outputFileName);
        PrintWriter printWriter = new PrintWriter(outputFile);
        for (int i = amountOfNumbers - 1; i >= 0; i--) {
            printWriter.println(numbers[i]);
        }

        printWriter.close();
    }

    public static void main(String[] args) {
        try {
            generateRandomNumberFile("integers-3000.txt", 3000);
            generateRandomNumberFile("integers-6000.txt", 6000);

            generateSortedNumberFile("integers-3000.txt", 3000);
            generateSortedNumberFile("integers-6000.txt", 6000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

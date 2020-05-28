package example.chapter01.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import example.chapter01.DetermineTheKthLargestNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class DetermineTheKthLargestNumberTest {

    private static final String ROOT_DIRECTORY = "src/data/";
    private static final String FILE_NAME_OF_3000_RANDOM_INTEGERS = "integers-3000.txt";
    private static final String FILE_NAME_OF_6000_RANDOM_INTEGERS = "integers-6000.txt";

    private static Method reverseIntArray;
    private static Method insertNumberIntoSortedArray;

    @BeforeAll
    public static void setUp() throws NoSuchMethodException {
        reverseIntArray = DetermineTheKthLargestNumber.class.getDeclaredMethod("reverseIntArray", int[].class);
        insertNumberIntoSortedArray = DetermineTheKthLargestNumber.class.getDeclaredMethod("insertNumberIntoSortedArray", int[].class, int.class);

        reverseIntArray.setAccessible(true);
        insertNumberIntoSortedArray.setAccessible(true);
    }

    private boolean testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(String filename, int amountOfNumbers,
                                                                           int k, int expectedResult, int algorithm) {

        int[] numbers = new int[amountOfNumbers];
        File file = new File(ROOT_DIRECTORY + filename);
        try {
            Scanner in = new Scanner(file);
            for (int i = 0; i < amountOfNumbers; i++) {
                numbers[i] = in.nextInt();
            }
            DetermineTheKthLargestNumber determineTheKthLargestNumber = new DetermineTheKthLargestNumber(numbers, k);
            if (algorithm == 1) {
                determineTheKthLargestNumber.calculateWithAlgorithm1();
            } else {
                determineTheKthLargestNumber.calculateWithAlgorithm2();
            }
            return determineTheKthLargestNumber.getResult() == expectedResult;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }


    @Test
    public void test1CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 1, 2145930509, 1);
        assertTrue(result);
    }

    @Test
    public void test2CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 3000, -2145177577, 1);
        assertTrue(result);
    }

    @Test
    public void test3CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 813, 968735089, 1);
        assertTrue(result);
    }

    @Test
    public void test4CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 1423, 94115109, 1);
        assertTrue(result);
    }

    @Test
    public void test5CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 2211, -1012733290, 1);
        assertTrue(result);
    }

    @Test
    public void test6CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 1, 2146337762, 1);
        assertTrue(result);
    }

    @Test
    public void test7CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 6000, -2146288019, 1);
        assertTrue(result);
    }

    @Test
    public void test8CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 1082, 1371032475, 1);
        assertTrue(result);
    }

    @Test
    public void test9CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 3062, -22139626, 1);
        assertTrue(result);
    }

    @Test
    public void test10CalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 4918, -1385165526, 1);
        assertTrue(result);
    }

    @Test
    public void test1CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 1, 2145930509, 2);
        assertTrue(result);
    }

    @Test
    public void test2CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 3000, -2145177577, 2);
        assertTrue(result);
    }

    @Test
    public void test3CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 813, 968735089, 2);
        assertTrue(result);
    }

    @Test
    public void test4CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 1423, 94115109, 2);
        assertTrue(result);
    }

    @Test
    public void test5CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_3000_RANDOM_INTEGERS,
                3000, 2211, -1012733290, 2);
        assertTrue(result);
    }

    @Test
    public void test6CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 1, 2146337762, 2);
        assertTrue(result);
    }

    @Test
    public void test7CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 6000, -2146288019, 2);
        assertTrue(result);
    }

    @Test
    public void test8CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 1082, 1371032475, 2);
        assertTrue(result);
    }

    @Test
    public void test9CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 3062, -22139626, 2);
        assertTrue(result);
    }

    @Test
    public void test10CalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(FILE_NAME_OF_6000_RANDOM_INTEGERS,
                6000, 4918, -1385165526, 2);
        assertTrue(result);
    }

    @Test
    public void test1ReverseIntArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{1, 2, 3, 4, 5};
        reverseIntArray.invoke(null, new Object[]{inputArray});
        int[] expectedOutputArray = new int[]{5, 4, 3, 2, 1};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test2ReverseIntArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{3};
        reverseIntArray.invoke(null, new Object[]{inputArray});
        int[] expectedOutputArray = new int[]{3};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test3ReverseIntArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{2, 3, 4, 5};
        reverseIntArray.invoke(null, new Object[]{inputArray});
        int[] expectedOutputArray = new int[]{5, 4, 3, 2};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test1InsertNumberIntoSortedArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{0};
        int insertedNumber = 10;
        insertNumberIntoSortedArray.invoke(null, inputArray, insertedNumber);
        int[] expectedOutputArray = new int[]{10};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test2InsertNumberIntoSortedArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{5, 3, 2, 1};
        int insertedNumber = 4;
        insertNumberIntoSortedArray.invoke(null, inputArray, insertedNumber);
        int[] expectedOutputArray = new int[]{5, 4, 3, 2};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test3InsertNumberIntoSortedArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{5, 4, 3, 1};
        int insertedNumber = 2;
        insertNumberIntoSortedArray.invoke(null, inputArray, insertedNumber);
        int[] expectedOutputArray = new int[]{5, 4, 3, 2};
        assertArrayEquals(expectedOutputArray, inputArray);
    }

    @Test
    public void test4InsertNumberIntoSortedArray() throws InvocationTargetException, IllegalAccessException {
        int[] inputArray = new int[]{5, 4, 3, 2};
        int insertedNumber = 10;
        insertNumberIntoSortedArray.invoke(null, inputArray, insertedNumber);
        int[] expectedOutputArray = new int[]{10, 5, 4, 3};
        assertArrayEquals(expectedOutputArray, inputArray);
    }
}

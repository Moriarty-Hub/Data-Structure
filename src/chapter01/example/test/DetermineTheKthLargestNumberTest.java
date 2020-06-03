package chapter01.example.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import chapter01.example.DetermineTheKthLargestNumber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import util.RandomIntegerArrayGenerator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class DetermineTheKthLargestNumberTest {

    private static final int AMOUNT_OF_RANDOM_NUMBER = 5000;
    private static int[] RANDOM_NUMBER_ARRAY;
    private static int[] DESCENDING_SORTED_ARRAY;

    private static Method reverseIntArray;
    private static Method insertNumberIntoSortedArray;

    @BeforeAll
    public static void setUp() throws NoSuchMethodException {
        reverseIntArray = DetermineTheKthLargestNumber.class.getDeclaredMethod("reverseIntArray", int[].class);
        insertNumberIntoSortedArray = DetermineTheKthLargestNumber.class.getDeclaredMethod("insertNumberIntoSortedArray", int[].class, int.class);

        reverseIntArray.setAccessible(true);
        insertNumberIntoSortedArray.setAccessible(true);

        RandomIntegerArrayGenerator generator = new RandomIntegerArrayGenerator(AMOUNT_OF_RANDOM_NUMBER);
        RANDOM_NUMBER_ARRAY = generator.getRandomArray();
        DESCENDING_SORTED_ARRAY = generator.getDescendingSortedArray();
    }

    private boolean testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(int k, int expectedResult, int algorithm) {

        DetermineTheKthLargestNumber determineTheKthLargestNumber = new DetermineTheKthLargestNumber(RANDOM_NUMBER_ARRAY, k);
        if (algorithm == 1) {
            determineTheKthLargestNumber.calculateWithAlgorithm1();
        } else {
            determineTheKthLargestNumber.calculateWithAlgorithm2();
        }
        return determineTheKthLargestNumber.getResult() == expectedResult;

    }

    @Test
    public void boundaryTest1OfCalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(1, DESCENDING_SORTED_ARRAY[0], 1);
        assertTrue(result);
    }

    @Test
    public void boundaryTest2OfCalculateWithAlgorithm1() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(AMOUNT_OF_RANDOM_NUMBER, DESCENDING_SORTED_ARRAY[AMOUNT_OF_RANDOM_NUMBER-1], 1);
        assertTrue(result);
    }

    @Test
    public void testCalculateWithAlgorithm1() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomIndex = random.nextInt(AMOUNT_OF_RANDOM_NUMBER) + 1;
            boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(randomIndex, DESCENDING_SORTED_ARRAY[randomIndex-1], 1);
            assertTrue(result);
        }
    }

    @Test
    public void boundaryTest1OfCalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(1, DESCENDING_SORTED_ARRAY[0], 2);
        assertTrue(result);
    }

    @Test
    public void boundaryTest2OfCalculateWithAlgorithm2() {
        boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(AMOUNT_OF_RANDOM_NUMBER, DESCENDING_SORTED_ARRAY[AMOUNT_OF_RANDOM_NUMBER-1], 2);
        assertTrue(result);
    }

    @Test
    public void testCalculateWithAlgorithm2() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int randomIndex = random.nextInt(AMOUNT_OF_RANDOM_NUMBER) + 1;
            boolean result = testDetermineTheKthLargestNumberWithSpecifiedAlgorithm(randomIndex, DESCENDING_SORTED_ARRAY[randomIndex-1], 2);
            assertTrue(result);
        }
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

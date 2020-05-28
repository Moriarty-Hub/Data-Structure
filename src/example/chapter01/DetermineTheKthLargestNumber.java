package example.chapter01;

import java.util.Arrays;

/**
 *   This class will help us to find the Kth largest number in an array, it was implemented with two algorithms.
 */
public class DetermineTheKthLargestNumber {

    private final int[] ints;
    private final int k;
    private final int amountOfNumbers;
    private int result;

    public DetermineTheKthLargestNumber(int[] ints, int k) {
        this.ints = ints;
        this.k = k;
        this.amountOfNumbers = ints.length;
    }

    /**
     *   这一算法借鉴了选择排序的思想，它会依次从数组中找到最大的、第二大的、第三大的...第K大的数字，将它们交换到数组开头并返回第K个数字。
     */
    public void calculateWithAlgorithm1() {
        for (int i = 0; i < k; i++) {
            int indexOfMaxNumber = i;
            for (int j = i; j < amountOfNumbers; j++) {
                if (ints[j] > ints[indexOfMaxNumber]) {
                    indexOfMaxNumber = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[indexOfMaxNumber];
            ints[indexOfMaxNumber] = temp;
        }
        result = ints[k-1];
    }

    /**
     *   这种算法的思想相对新颖，它首先会从原始数组里面取出前K个数字，将它们组成一个新的数组并按从大到小的顺序排序，对于原始数组里其他的每一个数字，
     * 则检测它是否大于新数组的最后一个数，如果不大于就跳过，如果大于就把它以插入排序的方式，插入到新数组的合适位置。由于新数组的大小是固定的，这也
     * 意味着每插入一个新的数字，就有一个原有的数字被舍弃。
     *   这一过程完成以后，新数组中的第K个数就是我们要找的数。
     *
     *   经测试发现，相比起第一种算法，这种算法可以节省30%-70%不等的时间。
     */
    public void calculateWithAlgorithm2() {
        int[] sortedArray = new int[k];
        System.arraycopy(ints, 0, sortedArray, 0, k);
        Arrays.sort(sortedArray);
        reverseIntArray(sortedArray);

        for (int i = k; i < amountOfNumbers; i++) {
            if (ints[i] > sortedArray[k-1]) {
                insertNumberIntoSortedArray(sortedArray, ints[i]);
            }
        }

        result = sortedArray[k-1];
    }

    private static void reverseIntArray(int[] array) {
        int front = 0;
        int end = array.length - 1;
        while (front <= end) {
            int temp = array[front];
            array[front] = array[end];
            array[end] = temp;
            ++front;
            --end;
        }
    }

    private static void insertNumberIntoSortedArray(int[] sortedArray, int number) {
        int length = sortedArray.length;
        int i = length - 2;
        while (i != -1 && number > sortedArray[i]) {
            sortedArray[i+1] = sortedArray[i];
            --i;
        }
        sortedArray[i+1] = number;
    }

    public int getResult() {
        return result;
    }

}

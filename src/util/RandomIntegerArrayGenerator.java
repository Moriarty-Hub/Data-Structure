package util;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomIntegerArrayGenerator {

    private final int[] randomArray;
    private final int[] sortedArray;

    public RandomIntegerArrayGenerator(int amount) {
        randomArray = new int[amount];

        Random random = new Random();
        for (int i = 0; i < amount; i++) {
            randomArray[i] = random.nextInt();
        }

        sortedArray = IntStream.of(randomArray).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
    }

    public int[] getRandomArray() {
        return randomArray;
    }

    public int[] getDescendingSortedArray() {
        return sortedArray;
    }

}

package util.test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import util.RandomIntegerArrayGenerator;

public class RandomIntegerArrayGeneratorTest {

    @Test
    public void testRandomIntegerArrayGenerator() {
        int amount = 5000;
        RandomIntegerArrayGenerator generator = new RandomIntegerArrayGenerator(amount);
        int[] descendingSortedArray = generator.getDescendingSortedArray();
        for (int i = 1; i < amount; i++) {
            assertTrue(descendingSortedArray[i] <= descendingSortedArray[i-1]);
        }
    }

}

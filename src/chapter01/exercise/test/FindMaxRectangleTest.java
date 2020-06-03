package chapter01.exercise.test;

import chapter01.exercise.FindMaxRectangle;
import chapter01.exercise.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxRectangleTest {

    @Test
    public void test1() {
        Rectangle[] rectangles = new Rectangle[] {new Rectangle(0, 0), new Rectangle(0, 0),
                                                  new Rectangle(0, 0), new Rectangle(0, 0)};
        Rectangle expectedResult = new Rectangle(0, 0);
        Rectangle result = FindMaxRectangle.of(rectangles);
        assertEquals(expectedResult.getArea(), result.getArea());
    }

    @Test
    public void test2() {
        Rectangle[] rectangles = new Rectangle[] {new Rectangle(10, 10), new Rectangle(8, 8),
                                                  new Rectangle(5, 5), new Rectangle(2, 2)};
        Rectangle expectedResult = new Rectangle(10, 10);
        Rectangle result = FindMaxRectangle.of(rectangles);
        assertEquals(expectedResult.getArea(), result.getArea());
    }

    @Test
    public void test3() {
        Rectangle[] rectangles = new Rectangle[] {new Rectangle(0, 0), new Rectangle(5, 5),
                                                  new Rectangle(10, 10)};
        Rectangle expectedResult = new Rectangle(10, 10);
        Rectangle result = FindMaxRectangle.of(rectangles);
        assertEquals(expectedResult.getArea(), result.getArea());
    }

    @Test
    public void test4() {
        Rectangle[] rectangles = new Rectangle[] {new Rectangle(10, 10), new Rectangle(-1, -1),
                                                  new Rectangle(0, 0)};
        assertThrows(IllegalArgumentException.class, () -> FindMaxRectangle.of(rectangles));
    }
}

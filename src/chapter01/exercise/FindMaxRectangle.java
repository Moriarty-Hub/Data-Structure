package chapter01.exercise;

import java.util.Comparator;

public class FindMaxRectangle {

    private static final RectangleComparator rectangleComparator = new RectangleComparator();

    public static Rectangle of(Rectangle[] rectangleArray) {
        int maxIndex = 0;
        for (int i = 1; i < rectangleArray.length; i++) {
            if (rectangleArray[i].getLength() < 0 || rectangleArray[i].getWidth() < 0) {
                throw new IllegalArgumentException("The length or width cannot be negative");
            }
            if (rectangleComparator.compare(rectangleArray[maxIndex], rectangleArray[i]) < 0) {
                maxIndex = i;
            }
        }
        return rectangleArray[maxIndex];
    }

}

class RectangleComparator implements Comparator<Rectangle> {

    @Override
    public int compare(Rectangle rectangle1, Rectangle rectangle2) {
        int area1 = rectangle1.getArea();
        int area2 = rectangle2.getArea();
        return Integer.compare(area1, area2);
    }

}
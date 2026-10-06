package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Split Variable (slide 25).
 * One variable per purpose, each with a meaningful name and declared final,
 * so the compiler guarantees it is assigned only once.
 */
public class RectangleReport {

    public void print(double height, double width) {
        final double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        final double area = height * width;
        System.out.println("Area: " + area);
    }
}

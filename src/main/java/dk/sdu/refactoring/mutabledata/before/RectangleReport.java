package dk.sdu.refactoring.mutabledata.before;

/** SMELL: reused variable - "temp" means two different things over its lifetime (slide 25). */
public class RectangleReport {

    public void print(double h, double w) {
        double temp = 2 * (h + w);
        System.out.println("Perimeter: " + temp);
        temp = h * w;                // SMELL: same variable, new meaning
        System.out.println("Area: " + temp);
    }
}

package dk.sdu.refactoring.mysteriousnames.before;

/**
 * SMELL: Mysterious Names (slide 13).
 * Class, field, method, parameter and local variable names reveal nothing about intent.
 * A reader must decode the arithmetic to discover that this computes compound interest.
 */
public class Calc {

    private final double r;            // SMELL: "r" -> rate? radius? ratio?

    public Calc(double r) {
        this.r = r;
    }

    // SMELL: "calc" says nothing; "a" and "n" are meaningless outside this method
    public double calc(double a, int n) {
        double t = a;                  // SMELL: "t" -> temp? total? time?
        for (int i = 0; i < n; i++) {
            t = t + t * r;
        }
        return t;
    }
}

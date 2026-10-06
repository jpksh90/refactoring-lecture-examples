package dk.sdu.refactoring.comments.before;

/**
 * SMELL: Comments hiding poor design (slide 55).
 * Every comment below is a deodorant: it explains WHAT the code does
 * because the names and structure don't.
 */
public class LoanCalculator {

    // calculates the monthly payment of a loan
    public double calc(double p, double r, int m) {
        // r must be between 0 and 1 (exclusive) - otherwise the result is nonsense
        // convert yearly rate to monthly rate
        double mr = r / 12;
        // apply the annuity formula
        double result = p * mr / (1 - Math.pow(1 + mr, -m));
        // round to 2 decimals
        return Math.round(result * 100) / 100.0;
    }
}

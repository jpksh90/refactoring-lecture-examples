package dk.sdu.refactoring.shotgunsurgery.after;

/**
 * REFACTORING: Move Function + Move Field + Combine Functions into Class (slide 33).
 * Everything about "how VAT works and how money is shown" now has ONE clear home.
 * The feature request from the "before" package is now a one-file change.
 *
 * (Tip from the slide: if the scattered logic is hidden behind many tiny wrappers,
 *  first Inline Function / Inline Class to see the real boundary, then move it here.)
 */
public final class Pricing {

    private static final double VAT_RATE = 0.25;            // REFACTORING: Move Field (was a literal in 3 classes)
    private static final double MAX_ORDER_GROSS = 10_000;

    private Pricing() {
    }

    public static double vat(double netAmount) {            // REFACTORING: Move Function
        return netAmount * VAT_RATE;
    }

    public static double gross(double netAmount) {
        return netAmount + vat(netAmount);
    }

    public static boolean exceedsLimit(double netAmount) {
        return gross(netAmount) > MAX_ORDER_GROSS;
    }

    public static String format(double amount) {            // REFACTORING: Move Function
        return String.format("%.2f DKK", amount);
    }
}

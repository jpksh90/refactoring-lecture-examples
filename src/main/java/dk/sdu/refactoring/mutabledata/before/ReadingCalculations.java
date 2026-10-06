package dk.sdu.refactoring.mutabledata.before;

/** SMELL: a family of functions all taking the same data as their first argument (slide 29). */
public class ReadingCalculations {

    public static double base(Reading r) {
        return r.quantity() * baseRate(r.month());
    }

    public static double tax(Reading r) {
        return Math.max(0, base(r) - 100) * 0.25;
    }

    public static double total(Reading r) {
        return base(r) + tax(r);
    }

    private static double baseRate(int month) {
        return month >= 6 && month <= 8 ? 1.5 : 2.0;
    }
}

package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Combine Functions into Class (slide 29).
 * The Reading that was passed to every function becomes a (final) field;
 * the functions become methods without that parameter.
 * (Alternative: Combine Functions into Transform -> return an enriched record.)
 */
public class ReadingAnalysis {

    private final Reading reading;

    public ReadingAnalysis(Reading reading) {
        this.reading = reading;
    }

    public double base() {
        return reading.quantity() * baseRate();
    }

    public double tax() {
        return Math.max(0, base() - 100) * 0.25;
    }

    public double total() {
        return base() + tax();
    }

    private double baseRate() {
        return reading.month() >= 6 && reading.month() <= 8 ? 1.5 : 2.0;
    }
}

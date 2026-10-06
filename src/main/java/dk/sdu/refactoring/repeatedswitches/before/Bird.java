package dk.sdu.refactoring.repeatedswitches.before;

/**
 * SMELL: Repeated Switches (slides 39-40).
 * The same switch on "type" appears in several methods. Adding a new bird type means
 * finding and editing EVERY switch (and the compiler won't tell you if you miss one
 * in the old-style switch statement).
 */
public class Bird {

    private final BirdType type;
    private final int coconuts;
    private final double voltage;
    private final boolean isNailed;

    public Bird(BirdType type, int coconuts, double voltage, boolean isNailed) {
        this.type = type;
        this.coconuts = coconuts;
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    public double getSpeed() {
        switch (type) {                                   // SMELL: switch #1
            case EUROPEAN:
                return baseSpeed();
            case AFRICAN:
                return baseSpeed() - loadFactor() * coconuts;
            case NORWEGIAN_BLUE:
                return isNailed ? 0 : baseSpeed(voltage);
        }
        throw new RuntimeException("unknown type");
    }

    public String plumage() {
        switch (type) {                                   // SMELL: switch #2 on the same type
            case EUROPEAN:
                return "average";
            case AFRICAN:
                return coconuts > 2 ? "tired" : "average";
            case NORWEGIAN_BLUE:
                return voltage > 100 ? "scorched" : "beautiful";
        }
        throw new RuntimeException("unknown type");
    }

    private double baseSpeed() { return 12; }

    private double baseSpeed(double voltage) { return Math.min(24, voltage / 10); }

    private double loadFactor() { return 2; }
}

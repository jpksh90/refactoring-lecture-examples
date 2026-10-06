package dk.sdu.refactoring.repeatedswitches.after;

public class NorwegianBlue extends Bird {

    private final double voltage;    // REFACTORING: Push Down Field
    private final boolean isNailed;

    public NorwegianBlue(double voltage, boolean isNailed) {
        this.voltage = voltage;
        this.isNailed = isNailed;
    }

    // was: case NORWEGIAN_BLUE in getSpeed()
    @Override
    public double getSpeed() {
        return isNailed ? 0 : baseSpeed(voltage);
    }

    // was: case NORWEGIAN_BLUE in plumage()
    @Override
    public String plumage() {
        return voltage > 100 ? "scorched" : "beautiful";
    }

    private double baseSpeed(double voltage) { return Math.min(24, voltage / 10); }
}

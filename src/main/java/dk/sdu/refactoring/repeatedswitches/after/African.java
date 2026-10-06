package dk.sdu.refactoring.repeatedswitches.after;

public class African extends Bird {

    private final int coconuts;   // REFACTORING: Push Down Field - only Africans carry coconuts

    public African(int coconuts) {
        this.coconuts = coconuts;
    }

    // was: case AFRICAN in getSpeed()
    @Override
    public double getSpeed() {
        return baseSpeed() - loadFactor() * coconuts;
    }

    // was: case AFRICAN in plumage()
    @Override
    public String plumage() {
        return coconuts > 2 ? "tired" : "average";
    }

    private double loadFactor() { return 2; }
}

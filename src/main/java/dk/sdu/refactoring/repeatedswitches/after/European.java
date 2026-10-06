package dk.sdu.refactoring.repeatedswitches.after;

public class European extends Bird {

    // was: case EUROPEAN in getSpeed(); plumage() inherits the default
    @Override
    public double getSpeed() {
        return baseSpeed();
    }
}

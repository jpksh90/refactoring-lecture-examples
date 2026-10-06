package dk.sdu.refactoring.lazyelements.before;

public class Driver {

    private final int lateDeliveries;

    public Driver(int lateDeliveries) {
        this.lateDeliveries = lateDeliveries;
    }

    public int rating() {
        return moreThanFiveLateDeliveries() ? 2 : 1;
    }

    // SMELL: Lazy Element (function) - the body is as clear as the name; the
    // indirection adds nothing and is used exactly once.
    private boolean moreThanFiveLateDeliveries() {
        return lateDeliveries > 5;
    }
}

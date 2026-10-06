package dk.sdu.refactoring.lazyelements.after;

public class Driver {

    private final int lateDeliveries;

    public Driver(int lateDeliveries) {
        this.lateDeliveries = lateDeliveries;
    }

    // REFACTORING: Inline Function - moreThanFiveLateDeliveries() was replaced by its body
    public int rating() {
        return lateDeliveries > 5 ? 2 : 1;
    }
}

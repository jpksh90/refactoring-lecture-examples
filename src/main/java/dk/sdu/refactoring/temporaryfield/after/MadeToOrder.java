package dk.sdu.refactoring.temporaryfield.after;

/**
 * REFACTORING: Extract Class (slide 45).
 * The temporary fields and the code that uses them get their own home.
 * A MadeToOrder object is always fully valid.
 */
public class MadeToOrder {

    private final double quantity;
    private final double length;

    public MadeToOrder(double quantity, double length) {
        this.quantity = quantity;
        this.length = length;
    }

    // REFACTORING: Move Function - the MTO part of shippingWeight() moved here
    public double shippingWeight(double density) {
        return length * quantity * density;
    }
}

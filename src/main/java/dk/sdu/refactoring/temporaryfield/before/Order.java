package dk.sdu.refactoring.temporaryfield.before;

/**
 * SMELL: Temporary Field (slides 44-45).
 * mtoQuantity and mtoLength are only meaningful when the order is "made to order".
 * For every other order they sit at 0 - the object is only partly valid,
 * and a reader has to discover the hidden rule "only look at these if isMto".
 */
public class Order {

    private final double quantity;
    private final double density;
    private final boolean isMto;

    private double mtoQuantity;   // SMELL: only set if isMto
    private double mtoLength;     // SMELL: only set if isMto

    public Order(double quantity, double density) {
        this.quantity = quantity;
        this.density = density;
        this.isMto = false;
    }

    public Order(double density, double mtoQuantity, double mtoLength) {
        this.quantity = 0;
        this.density = density;
        this.isMto = true;
        this.mtoQuantity = mtoQuantity;
        this.mtoLength = mtoLength;
    }

    public double shippingWeight() {
        return isMto
                ? mtoLength * mtoQuantity * density
                : quantity * density;
    }
}

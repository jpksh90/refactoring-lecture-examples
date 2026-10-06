package dk.sdu.refactoring.temporaryfield.after;

public class Order {

    private final double quantity;
    private final double density;
    private final MadeToOrder mto;     // REFACTORING: Extract Class - replaces mtoQuantity + mtoLength

    public Order(double quantity, double density) {
        this(quantity, density, null);
    }

    public Order(double density, MadeToOrder mto) {
        this(0, density, mto);
    }

    private Order(double quantity, double density, MadeToOrder mto) {
        this.quantity = quantity;
        this.density = density;
        this.mto = mto;
    }

    private boolean isMto() {
        return mto != null;
    }

    public double shippingWeight() {
        return isMto()
                ? mto.shippingWeight(density)
                : quantity * density;
        // Possible next step: Introduce Special Case / Replace Conditional with Polymorphism
        // so that even this conditional disappears.
    }
}

package dk.sdu.refactoring.mutabledata.before;

/** SMELL: derived state stored in a mutable field that can become stale (slide 28). */
public class ShoppingCart {

    private double subtotal;
    private double discount;
    private double discountedTotal;      // SMELL: derived from subtotal and discount

    public void addItem(double price) {
        subtotal += price;
        recalculate();                   // every mutator must remember this...
    }

    public void setDiscount(double discount) {
        this.discount = discount;
        // BUG waiting to happen: forgot recalculate() -> discountedTotal is stale!
    }

    private void recalculate() {
        discountedTotal = subtotal - discount;
    }

    public double getDiscountedTotal() {
        return discountedTotal;
    }
}

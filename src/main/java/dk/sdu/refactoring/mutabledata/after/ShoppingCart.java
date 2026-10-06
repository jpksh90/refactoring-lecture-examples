package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Replace Derived Variable with Query (slide 28).
 * The field discountedTotal and recalculate() are gone; the value is computed on demand,
 * so it can never be out of sync with its sources.
 *
 * NOTE: the "before" version had a latent bug (setDiscount forgot to recalculate).
 * A pure refactoring preserves behaviour, so in class you would first write a test that
 * exposes the stale value, fix it, and THEN refactor. The Demo shows the difference.
 */
public class ShoppingCart {

    private double subtotal;
    private double discount;

    public void addItem(double price) {
        subtotal += price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getDiscountedTotal() {
        return subtotal - discount;
    }
}

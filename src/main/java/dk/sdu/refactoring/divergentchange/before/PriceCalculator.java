package dk.sdu.refactoring.divergentchange.before;

/**
 * SMELL: Divergent Change inside one function (slide 32).
 * Pricing rules and shipping rules are entangled: a change to either touches this method.
 */
public class PriceCalculator {

    public double priceOrder(Product product, int qty, ShippingMethod method) {
        double base = product.basePrice() * qty;                       // pricing
        double perCase = base > method.discountThreshold()             // shipping
                ? method.discountedFee()
                : method.feePerCase();
        return base + qty * perCase;                                   // both
    }
}

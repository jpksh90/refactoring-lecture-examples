package dk.sdu.refactoring.divergentchange.after;

/**
 * REFACTORING: Split Phase (slide 32).
 *  1. Extract the second phase (shipping) into its own function: applyShipping().
 *  2. Introduce an intermediate data structure (PriceData) between the phases.
 *  3. Move all data the second phase needs into PriceData.
 * PRICING ---> PriceData ---> SHIPPING
 */
public class PriceCalculator {

    public double priceOrder(Product product, int qty, ShippingMethod method) {
        PriceData priceData = calculatePricingData(product, qty);   // phase 1
        return applyShipping(priceData, method);                    // phase 2
    }

    // Phase 1: pricing only - knows nothing about shipping
    public PriceData calculatePricingData(Product product, int qty) {
        return new PriceData(product.basePrice() * qty, qty);
    }

    // Phase 2: shipping only - knows nothing about products
    public double applyShipping(PriceData data, ShippingMethod method) {
        double perCase = data.base() > method.discountThreshold()
                ? method.discountedFee()
                : method.feePerCase();
        return data.base() + data.qty() * perCase;
    }
}

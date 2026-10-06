package dk.sdu.refactoring.longfunction.after;

import java.util.List;

/**
 * After refactoring, process() reads like a table of contents.
 * Each former "comment + chunk" became a well-named function, so the comments disappeared.
 */
public class OrderProcessor {

    public String process(List<LineItem> items, boolean premiumCustomer) {
        validate(items);
        double subtotal = subtotal(items);
        double discount = discount(subtotal, premiumCustomer);
        double shipping = shippingCost(totalWeight(items));
        return formatReceipt(subtotal, discount, shipping);
    }

    // REFACTORING: Extract Function  (was the "// validate the order" chunk)
    private void validate(List<LineItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
    }

    // REFACTORING: Split Loop - the original loop did two jobs; now each job has its own loop
    // REFACTORING: Extract Function - each loop got its own name
    private double subtotal(List<LineItem> items) {
        double subtotal = 0;
        for (LineItem item : items) {
            subtotal += item.price() * item.quantity();
        }
        return subtotal;
    }

    private double totalWeight(List<LineItem> items) {
        double totalWeight = 0;
        for (LineItem item : items) {
            totalWeight += item.weightKg() * item.quantity();
        }
        return totalWeight;
    }
    // (Next step could be Replace Loop with Pipeline - see package "loops".)

    private double discount(double subtotal, boolean premiumCustomer) {
        return qualifiesForDiscount(subtotal, premiumCustomer) ? subtotal * 0.10 : 0;
    }

    // REFACTORING: Decompose Conditional - the condition now has a name that states the business rule
    private boolean qualifiesForDiscount(double subtotal, boolean premiumCustomer) {
        double threshold = premiumCustomer ? 100 : 500;
        return subtotal > threshold;
    }

    // REFACTORING: Extract Function  (was the "// compute shipping" chunk)
    private double shippingCost(double totalWeight) {
        if (totalWeight < 1) return 5;
        if (totalWeight < 10) return 10;
        return 25;
    }

    // REFACTORING: Extract Function  (was the "// build the receipt" chunk)
    private String formatReceipt(double subtotal, double discount, double shipping) {
        return "Subtotal: " + subtotal + '\n'
             + "Discount: " + discount + '\n'
             + "Shipping: " + shipping + '\n'
             + "Total:    " + (subtotal - discount + shipping);
    }
}

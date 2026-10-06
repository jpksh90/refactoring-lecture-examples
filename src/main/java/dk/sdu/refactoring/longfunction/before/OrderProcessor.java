package dk.sdu.refactoring.longfunction.before;

import java.util.List;

/**
 * SMELL: Long Function (slide 15).
 * Signals visible here:
 *   - comments are needed to explain what each chunk does
 *   - a complex conditional hides the business rule
 *   - one loop does two unrelated jobs
 */
public class OrderProcessor {

    public String process(List<LineItem> items, boolean premiumCustomer) {
        // validate the order
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        // SMELL: one loop computes two different things (price AND weight)
        double subtotal = 0;
        double totalWeight = 0;
        for (LineItem item : items) {
            subtotal += item.price() * item.quantity();
            totalWeight += item.weightKg() * item.quantity();
        }

        // apply discount
        // SMELL: complex conditional - what is the business rule?
        double discount = 0;
        if ((premiumCustomer && subtotal > 100) || (!premiumCustomer && subtotal > 500)) {
            discount = subtotal * 0.10;
        }

        // compute shipping
        double shipping;
        if (totalWeight < 1) {
            shipping = 5;
        } else if (totalWeight < 10) {
            shipping = 10;
        } else {
            shipping = 25;
        }

        // build the receipt
        StringBuilder receipt = new StringBuilder();
        receipt.append("Subtotal: ").append(subtotal).append('\n');
        receipt.append("Discount: ").append(discount).append('\n');
        receipt.append("Shipping: ").append(shipping).append('\n');
        receipt.append("Total:    ").append(subtotal - discount + shipping);
        return receipt.toString();
    }
}

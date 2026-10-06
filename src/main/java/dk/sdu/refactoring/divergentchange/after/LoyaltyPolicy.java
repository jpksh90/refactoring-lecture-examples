package dk.sdu.refactoring.divergentchange.after;

/**
 * REFACTORING: Extract Class + Move Function - "Domain rules".
 * A loyalty-rule change now touches only this class. It no longer knows about storage.
 */
public class LoyaltyPolicy {

    public double discountRate(Customer customer) {
        int years = customer.yearsAsCustomer();
        if (years >= 10) return 0.15;
        if (years >= 3) return 0.05;
        return 0.0;
    }
}

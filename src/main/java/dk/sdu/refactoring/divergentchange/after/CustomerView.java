package dk.sdu.refactoring.divergentchange.after;

/**
 * REFACTORING: Extract Class + Move Function - "Presentation".
 * A UI change now touches only this class.
 */
public class CustomerView {

    private final LoyaltyPolicy loyaltyPolicy;

    public CustomerView(LoyaltyPolicy loyaltyPolicy) {
        this.loyaltyPolicy = loyaltyPolicy;
    }

    public String renderHtml(Customer customer) {
        return "<div class='customer'><b>" + customer.name() + "</b> - discount "
                + (int) (loyaltyPolicy.discountRate(customer) * 100) + "%</div>";
    }
}

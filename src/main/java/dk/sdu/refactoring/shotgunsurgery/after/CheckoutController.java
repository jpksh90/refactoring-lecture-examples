package dk.sdu.refactoring.shotgunsurgery.after;

public class CheckoutController {

    private final OrderService service = new OrderService();

    public String checkout(double netAmount) {
        double gross = service.placeOrder(netAmount);
        return "Thank you! You paid " + Pricing.format(gross);
    }
}

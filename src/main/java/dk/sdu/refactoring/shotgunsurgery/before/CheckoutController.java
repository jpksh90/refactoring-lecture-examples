package dk.sdu.refactoring.shotgunsurgery.before;

/**
 * SMELL: Shotgun Surgery (slide 33).
 * Feature request: "VAT changes to 22% and amounts must be shown with 2 decimals and 'kr.'".
 * To implement it you must edit THIS class, OrderService, OrderValidator and InvoiceMapper.
 * Miss one and the system is inconsistent.
 */
public class CheckoutController {

    private final OrderService service = new OrderService();

    public String checkout(double netAmount) {
        double gross = service.placeOrder(netAmount);
        return "Thank you! You paid " + String.format("%.2f DKK", gross);   // SMELL: formatting rule copy #1
    }
}

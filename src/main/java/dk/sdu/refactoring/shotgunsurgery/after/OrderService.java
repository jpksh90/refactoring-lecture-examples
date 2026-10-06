package dk.sdu.refactoring.shotgunsurgery.after;

public class OrderService {

    private final OrderValidator validator = new OrderValidator();
    private final InvoiceMapper mapper = new InvoiceMapper();

    public double placeOrder(double netAmount) {
        validator.validate(netAmount);
        System.out.println(mapper.toInvoiceLine(netAmount));
        return Pricing.gross(netAmount);
    }
}

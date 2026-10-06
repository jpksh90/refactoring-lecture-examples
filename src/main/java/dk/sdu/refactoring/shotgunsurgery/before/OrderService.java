package dk.sdu.refactoring.shotgunsurgery.before;

public class OrderService {

    private final OrderValidator validator = new OrderValidator();
    private final InvoiceMapper mapper = new InvoiceMapper();

    public double placeOrder(double netAmount) {
        validator.validate(netAmount);
        double gross = netAmount * 1.25;                                     // SMELL: VAT rule copy #1
        System.out.println(mapper.toInvoiceLine(netAmount));
        return gross;
    }
}

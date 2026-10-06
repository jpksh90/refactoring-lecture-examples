package dk.sdu.refactoring.shotgunsurgery.before;

public class InvoiceMapper {

    public String toInvoiceLine(double netAmount) {
        double vat = netAmount * 0.25;                                       // SMELL: VAT rule copy #3
        return "net " + String.format("%.2f DKK", netAmount)                 // SMELL: formatting copy #3
             + " + VAT " + String.format("%.2f DKK", vat);
    }
}

package dk.sdu.refactoring.shotgunsurgery.after;

public class InvoiceMapper {

    public String toInvoiceLine(double netAmount) {
        return "net " + Pricing.format(netAmount) + " + VAT " + Pricing.format(Pricing.vat(netAmount));
    }
}

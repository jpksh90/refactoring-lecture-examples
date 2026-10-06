package dk.sdu.refactoring.duplicatecode.before;

/**
 * SMELL: Duplicate Code (slide 13).
 * The header block and the VAT calculation appear in both methods.
 * If the company name or the VAT rate changes, both places must be edited
 * (and sooner or later one of them will be forgotten).
 */
public class ReceiptPrinter {

    public void printInvoice(String customer, double amount) {
        // SMELL: duplicated header
        System.out.println("==============================");
        System.out.println("  ACME Corp. - INVOICE");
        System.out.println("==============================");
        // SMELL: duplicated VAT calculation
        double vat = amount * 0.25;
        double total = amount + vat;
        System.out.println("Customer: " + customer);
        System.out.println("Amount due (incl. VAT): " + total);
    }

    public void printReceipt(String customer, double amount, String paymentMethod) {
        // SMELL: duplicated header
        System.out.println("==============================");
        System.out.println("  ACME Corp. - RECEIPT");
        System.out.println("==============================");
        // SMELL: duplicated VAT calculation
        double vat = amount * 0.25;
        double total = amount + vat;
        System.out.println("Customer: " + customer);
        System.out.println("Paid (incl. VAT): " + total + " by " + paymentMethod);
    }
}

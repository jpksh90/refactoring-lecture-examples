package dk.sdu.refactoring.duplicatecode.after;

/**
 * The shared logic now lives in exactly one place.
 * Steps:
 *  1. Extract Function on the header lines, parameterising the varying part (the title).
 *  2. Extract Function on the VAT calculation.
 *  3. Replace both duplicated blocks with calls to the new functions.
 */
public class ReceiptPrinter {

    private static final double VAT_RATE = 0.25;

    public void printInvoice(String customer, double amount) {
        printHeader("INVOICE");
        System.out.println("Customer: " + customer);
        System.out.println("Amount due (incl. VAT): " + withVat(amount));
    }

    public void printReceipt(String customer, double amount, String paymentMethod) {
        printHeader("RECEIPT");
        System.out.println("Customer: " + customer);
        System.out.println("Paid (incl. VAT): " + withVat(amount) + " by " + paymentMethod);
    }

    // REFACTORING: Extract Function (+ parameterise the part that differed: the title)
    private void printHeader(String title) {
        System.out.println("==============================");
        System.out.println("  ACME Corp. - " + title);
        System.out.println("==============================");
    }

    // REFACTORING: Extract Function - the VAT rule now has one home
    private double withVat(double amount) {
        return amount + amount * VAT_RATE;
    }
}

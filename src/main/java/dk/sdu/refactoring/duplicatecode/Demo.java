package dk.sdu.refactoring.duplicatecode;

/** Duplicate Code -> Extract Function. Both versions must print the same text. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- before ---");
        var before = new dk.sdu.refactoring.duplicatecode.before.ReceiptPrinter();
        before.printInvoice("Alice", 100);
        before.printReceipt("Bob", 200, "MobilePay");

        System.out.println("--- after ---");
        var after = new dk.sdu.refactoring.duplicatecode.after.ReceiptPrinter();
        after.printInvoice("Alice", 100);
        after.printReceipt("Bob", 200, "MobilePay");
    }
}

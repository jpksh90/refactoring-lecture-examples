package dk.sdu.refactoring.longparameterlist.after;

import java.util.List;

public class Ledger {

    private final List<Invoice> invoices;

    public Ledger(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    // REFACTORING: Introduce Parameter Object - (start, end) -> DateRange
    // REFACTORING: Move Function - the range check moved into DateRange.contains()
    public double amountInvoiced(DateRange range) {
        double sum = 0;
        for (Invoice i : invoices) {
            if (range.contains(i.issued())) sum += i.amount();
        }
        return sum;
    }

    public double amountReceived(DateRange range) {
        double sum = 0;
        for (Invoice i : invoices) {
            if (range.contains(i.issued()) && i.paid()) sum += i.amount();
        }
        return sum;
    }

    public double amountOverdue(DateRange range) {
        double sum = 0;
        for (Invoice i : invoices) {
            if (range.contains(i.issued()) && !i.paid()) sum += i.amount();
        }
        return sum;
    }
}

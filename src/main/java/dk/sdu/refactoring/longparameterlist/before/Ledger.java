package dk.sdu.refactoring.longparameterlist.before;

import java.time.LocalDate;
import java.util.List;

/**
 * SMELL: Long Parameter List / Data Clump (slides 17-18).
 * The same pair (start, end) travels together through every method.
 * Separate values hide a single domain concept: a date range.
 */
public class Ledger {

    private final List<Invoice> invoices;

    public Ledger(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    public double amountInvoiced(LocalDate start, LocalDate end) {
        double sum = 0;
        for (Invoice i : invoices) {
            // SMELL: the "is this date in the range?" logic is repeated in every method
            if (!i.issued().isBefore(start) && !i.issued().isAfter(end)) sum += i.amount();
        }
        return sum;
    }

    public double amountReceived(LocalDate start, LocalDate end) {
        double sum = 0;
        for (Invoice i : invoices) {
            if (!i.issued().isBefore(start) && !i.issued().isAfter(end) && i.paid()) sum += i.amount();
        }
        return sum;
    }

    public double amountOverdue(LocalDate start, LocalDate end) {
        double sum = 0;
        for (Invoice i : invoices) {
            if (!i.issued().isBefore(start) && !i.issued().isAfter(end) && !i.paid()) sum += i.amount();
        }
        return sum;
    }
}

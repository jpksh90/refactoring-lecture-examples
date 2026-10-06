package dk.sdu.refactoring.longparameterlist;

import java.time.LocalDate;
import java.util.List;

/**
 * Long Parameter List -> Introduce Parameter Object, Preserve Whole Object,
 * Replace Parameter with Query, Remove Flag Argument.
 */
public class Demo {
    public static void main(String[] args) {
        LocalDate start = LocalDate.of(2026, 1, 1);
        LocalDate end = LocalDate.of(2026, 3, 31);

        System.out.println("--- before ---");
        var ledgerBefore = new dk.sdu.refactoring.longparameterlist.before.Ledger(List.of(
                new dk.sdu.refactoring.longparameterlist.before.Invoice(LocalDate.of(2026, 2, 1), 100, true),
                new dk.sdu.refactoring.longparameterlist.before.Invoice(LocalDate.of(2026, 3, 1), 50, false),
                new dk.sdu.refactoring.longparameterlist.before.Invoice(LocalDate.of(2026, 5, 1), 70, false)));
        System.out.println(ledgerBefore.amountInvoiced(start, end) + " / "
                + ledgerBefore.amountReceived(start, end) + " / " + ledgerBefore.amountOverdue(start, end));
        var alice = new dk.sdu.refactoring.longparameterlist.before.Customer("Alice", "SE");
        // What does "true" mean here? You have to open ShippingService to find out.
        new dk.sdu.refactoring.longparameterlist.before.ShippingService()
                .cost(alice, alice.name(), alice.country(), 3, 3 * 10, true);

        System.out.println("--- after ---");
        var ledgerAfter = new dk.sdu.refactoring.longparameterlist.after.Ledger(List.of(
                new dk.sdu.refactoring.longparameterlist.after.Invoice(LocalDate.of(2026, 2, 1), 100, true),
                new dk.sdu.refactoring.longparameterlist.after.Invoice(LocalDate.of(2026, 3, 1), 50, false),
                new dk.sdu.refactoring.longparameterlist.after.Invoice(LocalDate.of(2026, 5, 1), 70, false)));
        var q1 = new dk.sdu.refactoring.longparameterlist.after.DateRange(start, end);
        System.out.println(ledgerAfter.amountInvoiced(q1) + " / "
                + ledgerAfter.amountReceived(q1) + " / " + ledgerAfter.amountOverdue(q1));
        new dk.sdu.refactoring.longparameterlist.after.ShippingService()
                .expressCost(new dk.sdu.refactoring.longparameterlist.after.Customer("Alice", "SE"), 3);
    }
}

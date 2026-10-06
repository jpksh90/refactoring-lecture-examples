package dk.sdu.refactoring.mutabledata;

import dk.sdu.refactoring.mutabledata.after.ReadingAnalysis;
import dk.sdu.refactoring.mutabledata.before.ReadingCalculations;

/**
 * Mutable Data (slides 21-30) -> Encapsulate Variable (see package globaldata), Remove Setting Method,
 * Separate Query from Modifier, Split Variable, Slide Statements + Extract Function,
 * Replace Derived Variable with Query, Combine Functions into Class, Change Reference to Value.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("== Remove Setting Method ==");
        var accBefore = new dk.sdu.refactoring.mutabledata.before.Account();
        accBefore.setId("DK-001");
        accBefore.setId("HACKED");                       // compiles - nothing prevents it
        System.out.println("before: " + accBefore.getId());
        var accAfter = new dk.sdu.refactoring.mutabledata.after.Account("DK-001");
        System.out.println("after : " + accAfter.getId()); // there is no setId to call

        System.out.println("== Separate Query from Modifier ==");
        var cBefore = new dk.sdu.refactoring.mutabledata.before.SalesCounter();
        cBefore.record(10);
        System.out.println("before: " + cBefore.totalAndReset() + ", asked again: " + cBefore.totalAndReset());
        var cAfter = new dk.sdu.refactoring.mutabledata.after.SalesCounter();
        cAfter.record(10);
        System.out.println("after : " + cAfter.total() + ", asked again: " + cAfter.total());
        cAfter.reset();

        System.out.println("== Split Variable ==");
        new dk.sdu.refactoring.mutabledata.before.RectangleReport().print(2, 3);
        new dk.sdu.refactoring.mutabledata.after.RectangleReport().print(2, 3);

        System.out.println("== Slide Statements + Extract Function ==");
        new dk.sdu.refactoring.mutabledata.before.Checkout().finish(200, 0.1, "Alice");
        new dk.sdu.refactoring.mutabledata.after.Checkout().finish(200, 0.1, "Alice");

        System.out.println("== Replace Derived Variable with Query ==");
        var cartBefore = new dk.sdu.refactoring.mutabledata.before.ShoppingCart();
        cartBefore.addItem(100);
        cartBefore.setDiscount(20);
        System.out.println("before: " + cartBefore.getDiscountedTotal() + "   <- stale! discount ignored");
        var cartAfter = new dk.sdu.refactoring.mutabledata.after.ShoppingCart();
        cartAfter.addItem(100);
        cartAfter.setDiscount(20);
        System.out.println("after : " + cartAfter.getDiscountedTotal());

        System.out.println("== Combine Functions into Class ==");
        var rB = new dk.sdu.refactoring.mutabledata.before.Reading("Alice", 120, 7);
        System.out.println("before: " + ReadingCalculations.total(rB));
        var rA = new dk.sdu.refactoring.mutabledata.after.Reading("Alice", 120, 7);
        System.out.println("after : " + new ReadingAnalysis(rA).total());

        System.out.println("== Change Reference to Value ==");
        var sharedBefore = new dk.sdu.refactoring.mutabledata.before.Money(100, "DKK");
        var priceBefore = sharedBefore;
        sharedBefore.setAmount(120);
        System.out.println("before: price = " + priceBefore + "   <- changed behind our back");
        var sharedAfter = new dk.sdu.refactoring.mutabledata.after.Money(100, "DKK");
        var priceAfter = sharedAfter;
        var revised = sharedAfter.withAmount(120);
        System.out.println("after : price = " + priceAfter + ", revised = " + revised);
    }
}

package dk.sdu.refactoring.longfunction;

import java.time.LocalDate;
import java.util.List;

/**
 * Long Function -> Extract Function, Decompose Conditional, Split Loop.
 * Other options from slide 15: Replace Conditional with Polymorphism (see "repeatedswitches"),
 * Replace Function with Command.
 */
public class Demo {

    private static final LocalDate SUMMER_START = LocalDate.of(2026, 6, 1);
    private static final LocalDate SUMMER_END = LocalDate.of(2026, 8, 31);
    private static final LocalDate JULY = LocalDate.of(2026, 7, 15);
    private static final LocalDate DECEMBER = LocalDate.of(2026, 12, 15);

    public static void main(String[] args) {
        System.out.println("--- before ---");
        System.out.println(new dk.sdu.refactoring.longfunction.before.OrderProcessor().process(List.of(
                new dk.sdu.refactoring.longfunction.before.LineItem("Book", 60, 2, 0.5),
                new dk.sdu.refactoring.longfunction.before.LineItem("Lamp", 40, 1, 3)), true));
        var planB = new dk.sdu.refactoring.longfunction.before.Plan(SUMMER_START, SUMMER_END, 2.0, 15, 1.5);
        var calcB = new dk.sdu.refactoring.longfunction.before.ChargeCalculator();
        System.out.println("July: " + calcB.charge(10, JULY, planB) + ", December: " + calcB.charge(10, DECEMBER, planB));

        System.out.println("--- after ---");
        System.out.println(new dk.sdu.refactoring.longfunction.after.OrderProcessor().process(List.of(
                new dk.sdu.refactoring.longfunction.after.LineItem("Book", 60, 2, 0.5),
                new dk.sdu.refactoring.longfunction.after.LineItem("Lamp", 40, 1, 3)), true));
        var planA = new dk.sdu.refactoring.longfunction.after.Plan(SUMMER_START, SUMMER_END, 2.0, 15, 1.5);
        var calcA = new dk.sdu.refactoring.longfunction.after.ChargeCalculator();
        System.out.println("July: " + calcA.charge(10, JULY, planA) + ", December: " + calcA.charge(10, DECEMBER, planA));
    }
}

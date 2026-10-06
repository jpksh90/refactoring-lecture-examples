package dk.sdu.refactoring.longfunction.after;

import java.time.LocalDate;

/**
 * REFACTORING: Decompose Conditional (slide 16).
 *  1. Extract Function on the condition  -> isSummer(date, plan)
 *  2. Extract Function on the then-branch -> summerCharge(quantity, plan)
 *  3. Extract Function on the else-branch -> regularCharge(quantity, plan)
 *  4. (optional) Replace the if/else with a conditional expression
 * The method now reads as the business rule:
 * "in summer use the summer charge, otherwise the regular charge".
 */
public class ChargeCalculator {

    public double charge(int quantity, LocalDate date, Plan plan) {
        return isSummer(date, plan)
                ? summerCharge(quantity, plan)
                : regularCharge(quantity, plan);
    }

    // REFACTORING: Extract Function (the condition) - the name states the question being asked
    private boolean isSummer(LocalDate date, Plan plan) {
        return !date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd());
    }

    // REFACTORING: Extract Function (the then-branch)
    private double summerCharge(int quantity, Plan plan) {
        return quantity * plan.summerRate();
    }

    // REFACTORING: Extract Function (the else-branch)
    private double regularCharge(int quantity, Plan plan) {
        return quantity * plan.regularRate() + plan.regularServiceCharge();
    }
}

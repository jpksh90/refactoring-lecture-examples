package dk.sdu.refactoring.longfunction.before;

import java.time.LocalDate;

/**
 * SMELL: Long Function - complex conditional (slides 15-16).
 * To understand this method the reader has to decode HOW it decides
 * (date-range arithmetic and pricing formulas) before seeing WHAT it decides
 * ("summer tariff or regular tariff?").
 */
public class ChargeCalculator {

    public double charge(int quantity, LocalDate date, Plan plan) {
        double charge;
        // SMELL: low-level condition hides intent - this double negation is really just "is it summer?"
        if (!date.isBefore(plan.summerStart()) && !date.isAfter(plan.summerEnd())) {
            // SMELL: raw formula - what does this branch mean in business terms?
            charge = quantity * plan.summerRate();
        } else {
            // SMELL: raw formula - and why is a service charge only added here?
            charge = quantity * plan.regularRate() + plan.regularServiceCharge();
        }
        return charge;
    }
}

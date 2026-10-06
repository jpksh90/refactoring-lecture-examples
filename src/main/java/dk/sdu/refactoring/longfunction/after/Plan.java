package dk.sdu.refactoring.longfunction.after;

import java.time.LocalDate;

/** Tariff plan used by the Decompose Conditional example (slide 16). */
public record Plan(LocalDate summerStart, LocalDate summerEnd,
                   double regularRate, double regularServiceCharge, double summerRate) {
}

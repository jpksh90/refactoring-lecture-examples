package dk.sdu.refactoring.longparameterlist.before;

import java.time.LocalDate;

public record Invoice(LocalDate issued, double amount, boolean paid) {
}

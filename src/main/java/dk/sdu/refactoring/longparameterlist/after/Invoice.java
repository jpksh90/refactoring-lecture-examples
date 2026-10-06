package dk.sdu.refactoring.longparameterlist.after;

import java.time.LocalDate;

public record Invoice(LocalDate issued, double amount, boolean paid) {
}

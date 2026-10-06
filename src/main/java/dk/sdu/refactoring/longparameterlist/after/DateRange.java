package dk.sdu.refactoring.longparameterlist.after;

import java.time.LocalDate;

/**
 * REFACTORING: Introduce Parameter Object (slide 18).
 * The concept now has a name - and it becomes a natural home for behaviour
 * that used to be duplicated in every caller (contains()).
 */
public record DateRange(LocalDate start, LocalDate end) {

    public boolean contains(LocalDate date) {
        return !date.isBefore(start) && !date.isAfter(end);
    }
}

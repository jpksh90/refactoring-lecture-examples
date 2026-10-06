package dk.sdu.refactoring.mutabledata.after;

/** A meter reading: who, how many units, which month. */
public record Reading(String customer, double quantity, int month) {
}

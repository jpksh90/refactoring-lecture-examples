package dk.sdu.refactoring.mutabledata.before;

/** A meter reading: who, how many units, which month. */
public record Reading(String customer, double quantity, int month) {
}

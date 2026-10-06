package dk.sdu.refactoring.divergentchange.after;

/**
 * REFACTORING: Split Phase - the intermediate data structure passed between the two phases.
 * An immutable record is fine here: it is a result object, not a "Data Class" smell.
 */
public record PriceData(double base, int qty) {
}

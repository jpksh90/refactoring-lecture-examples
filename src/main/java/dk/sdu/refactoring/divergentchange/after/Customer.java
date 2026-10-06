package dk.sdu.refactoring.divergentchange.after;

/** The domain object that all three concerns share (replaces the raw String[] row). */
public record Customer(String id, String name, int yearsAsCustomer) {
}

package dk.sdu.refactoring.refusedbequest.before;

/**
 * SMELL: Refused Bequest (slides 51-52).
 * quota() and salesTarget only make sense for Salesperson,
 * yet every Employee (including Engineer) inherits them.
 */
public class Employee {

    private final String name;
    protected double salesTarget;          // SMELL: Salesperson only

    public Employee(String name) {
        this.name = name;
    }

    public String name() { return name; }

    public double quota() {                // SMELL: Salesperson only
        return salesTarget * 0.8;
    }
}

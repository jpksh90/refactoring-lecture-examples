package dk.sdu.refactoring.refusedbequest.after;

/**
 * Specialised behaviour now lives with the subclass that uses it.
 * If later the "is-a Employee" relationship itself becomes a problem, apply
 * Replace Subclass with Delegate (slide 53): hold an Employee field and forward name().
 */
public class Salesperson extends Employee {

    private final double salesTarget;      // REFACTORING: Push Down Field

    public Salesperson(String name, double salesTarget) {
        super(name);
        this.salesTarget = salesTarget;
    }

    public double quota() {                // REFACTORING: Push Down Method
        return salesTarget * 0.8;
    }
}

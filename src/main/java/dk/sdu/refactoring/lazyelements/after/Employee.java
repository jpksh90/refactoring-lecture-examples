package dk.sdu.refactoring.lazyelements.after;

/**
 * REFACTORING: Collapse Hierarchy - the empty subclass Salesman was merged into Employee.
 * Clients that used "new Salesman(..)" now use "new Employee(..)".
 */
public class Employee {

    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

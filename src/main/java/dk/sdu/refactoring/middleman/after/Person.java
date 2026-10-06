package dk.sdu.refactoring.middleman.after;

/**
 * REFACTORING: Remove Middle Man (slide 44).
 *  1. Create a getter for the delegate: department().
 *  2. Change each client to call the delegate directly.
 *  3. Delete the forwarding methods (Inline Function on each).
 *
 * Remove Middle Man and Hide Delegate (package "messagechains") are opposites.
 * There is no "right" amount of hiding - adjust as the code evolves.
 * Keeping ONE delegating method that clients use a lot (e.g. manager()) is perfectly fine.
 */
public class Person {

    private final String name;
    private final Department department;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String name() { return name; }

    public Department department() {
        return department;
    }
}

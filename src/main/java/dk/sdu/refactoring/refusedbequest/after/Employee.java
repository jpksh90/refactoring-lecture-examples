package dk.sdu.refactoring.refusedbequest.after;

/**
 * REFACTORING: Push Down Method + Push Down Field (slide 52).
 * Employee keeps only what ALL employees share.
 */
public class Employee {

    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String name() { return name; }
}

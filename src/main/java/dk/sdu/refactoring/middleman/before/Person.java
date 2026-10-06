package dk.sdu.refactoring.middleman.before;

/**
 * SMELL: Middle Man (slide 44).
 * Hide Delegate was applied too eagerly: every time Department grew a feature,
 * Person got another forwarding method. Person now mostly forwards calls and
 * adds no behaviour of its own:   client -> Person -> Department
 */
public class Person {

    private final String name;
    private final Department department;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String name() { return name; }

    public String departmentCode() { return department.code(); }      // SMELL: pure delegation

    public String manager() { return department.manager(); }          // SMELL: pure delegation

    public double departmentBudget() { return department.budget(); }  // SMELL: pure delegation

    public String building() { return department.building(); }        // SMELL: pure delegation
}

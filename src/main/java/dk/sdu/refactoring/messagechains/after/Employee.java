package dk.sdu.refactoring.messagechains.after;

public class Employee {

    private final String name;
    private final Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }

    // REFACTORING: Hide Delegate (slide 48) - Employee answers the question itself;
    // the fact that the manager is stored in Department is now an internal detail.
    public Person manager() {
        return department.getManager();
    }
    // After all clients use manager(), getDepartment() could be removed (if nobody else needs it).
}

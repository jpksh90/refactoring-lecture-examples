package dk.sdu.refactoring.messagechains.before;

public class Employee {

    private final String name;
    private final Department department;

    public Employee(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() { return name; }

    public Department getDepartment() { return department; }
}

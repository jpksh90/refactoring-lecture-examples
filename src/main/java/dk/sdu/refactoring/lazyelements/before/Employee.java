package dk.sdu.refactoring.lazyelements.before;

public class Employee {

    private final String name;

    public Employee(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

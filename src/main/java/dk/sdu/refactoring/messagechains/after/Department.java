package dk.sdu.refactoring.messagechains.after;

public class Department {

    private final String name;
    private final Person manager;

    public Department(String name, Person manager) {
        this.name = name;
        this.manager = manager;
    }

    public String getName() { return name; }

    public Person getManager() { return manager; }
}

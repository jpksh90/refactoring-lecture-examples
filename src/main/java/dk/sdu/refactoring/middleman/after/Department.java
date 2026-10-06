package dk.sdu.refactoring.middleman.after;

public class Department {

    private final String code;
    private final String manager;
    private final double budget;
    private final String building;

    public Department(String code, String manager, double budget, String building) {
        this.code = code;
        this.manager = manager;
        this.budget = budget;
        this.building = building;
    }

    public String code() { return code; }

    public String manager() { return manager; }

    public double budget() { return budget; }

    public String building() { return building; }
}

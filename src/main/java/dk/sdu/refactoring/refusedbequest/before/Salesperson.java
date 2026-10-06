package dk.sdu.refactoring.refusedbequest.before;

public class Salesperson extends Employee {

    public Salesperson(String name, double salesTarget) {
        super(name);
        this.salesTarget = salesTarget;
    }
}

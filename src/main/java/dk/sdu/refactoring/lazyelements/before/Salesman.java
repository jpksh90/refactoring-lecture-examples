package dk.sdu.refactoring.lazyelements.before;

/**
 * SMELL: Lazy Element (inheritance layer) - Salesman adds no fields and no behaviour.
 * The hierarchy suggests a difference that does not exist.
 */
public class Salesman extends Employee {

    public Salesman(String name) {
        super(name);
    }
}

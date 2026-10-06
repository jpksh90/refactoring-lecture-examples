package dk.sdu.refactoring.refusedbequest.after;

/** Nothing to refuse any more - the UnsupportedOperationException override is gone. */
public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }
}

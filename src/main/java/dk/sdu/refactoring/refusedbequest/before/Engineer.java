package dk.sdu.refactoring.refusedbequest.before;

public class Engineer extends Employee {

    public Engineer(String name) {
        super(name);
    }

    // SMELL: the subclass explicitly refuses what it inherited
    @Override
    public double quota() {
        throw new UnsupportedOperationException("Engineers have no quota");
    }
}

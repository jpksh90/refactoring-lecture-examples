package dk.sdu.refactoring.primitiveobsession.after;

/**
 * REFACTORING: Replace Type Code with Subclasses (int type -> CustomerType)
 *            + Replace Conditional with Polymorphism (the if-chain on type disappears).
 * In Java an enum whose constants carry their own behaviour is the lightweight form of
 * "type code -> subclasses". For a full class hierarchy see package "repeatedswitches".
 */
public enum CustomerType {
    REGULAR(0.0),
    GOLD(0.10),
    PLATINUM(0.20);

    private final double discountRate;

    CustomerType(double discountRate) {
        this.discountRate = discountRate;
    }

    public double discountRate() {
        return discountRate;
    }
}

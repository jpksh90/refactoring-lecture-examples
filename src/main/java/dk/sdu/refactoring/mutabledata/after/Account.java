package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Remove Setting Method (slide 23).
 *  1. Add the value as a constructor parameter.
 *  2. Replace calls to setId(..) with the constructor argument.
 *  3. Delete setId(..) and make the field final.
 * The identifier is now fixed at creation - the compiler enforces it.
 */
public class Account {

    private final String id;
    private double balance;

    public Account(String id) {
        this.id = id;
    }

    public String getId() { return id; }

    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
}

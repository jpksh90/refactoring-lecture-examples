package dk.sdu.refactoring.mutabledata.before;

/** SMELL: Mutable Data - an identifier that can change after creation (slide 23). */
public class Account {

    private String id;
    private double balance;

    public Account() {
    }

    public String getId() { return id; }

    public void setId(String id) {   // SMELL: the identity of an account should never change
        this.id = id;
    }

    public double getBalance() { return balance; }

    public void deposit(double amount) { balance += amount; }
}

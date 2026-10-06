package dk.sdu.refactoring.mutabledata.before;

/** SMELL: a mutable "value" shared by reference - changing it in one place changes it everywhere (slide 30). */
public class Money {

    private double amount;
    private final String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() { return amount; }

    public void setAmount(double amount) { this.amount = amount; }

    @Override
    public String toString() { return amount + " " + currency; }
}

package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Change Reference to Value (slide 30).
 *  1. Make the fields final (Remove Setting Method).
 *  2. Replace the setter with a "wither" that returns a NEW object.
 *  3. Give it value-based equality - a Java record does this for us.
 */
public record Money(double amount, String currency) {

    public Money withAmount(double newAmount) {
        return new Money(newAmount, currency);
    }

    @Override
    public String toString() { return amount + " " + currency; }
}

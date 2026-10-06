package dk.sdu.refactoring.featureenvy.after;

public class Account {

    private final AccountType type;
    private final int daysOverdrawn;

    public Account(AccountType type, int daysOverdrawn) {
        this.type = type;
        this.daysOverdrawn = daysOverdrawn;
    }

    public int daysOverdrawn() {
        return daysOverdrawn;
    }

    // REFACTORING: Move Function - the old method stays as a delegating method so callers keep working.
    // (Optionally Inline Function later so callers use the type directly.)
    public double overdraftCharge() {
        return type.overdraftCharge(daysOverdrawn);
    }

    // REFACTORING: Move Function (slide 36) - Invoice.bankCharge(account) -> Account.bankCharge()
    // The behaviour now lives next to the data it uses; the Account parameter disappeared.
    public double bankCharge() {
        double result = 4.5;
        if (daysOverdrawn() > 0) {
            result += overdraftCharge();
        }
        return result;
    }
}

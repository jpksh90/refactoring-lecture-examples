package dk.sdu.refactoring.featureenvy.before;

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

    // SMELL: Feature Envy (slide 34) - the pricing rules depend on the ACCOUNT TYPE
    // (premium or not). When a new account type is added, this is the wrong place to change.
    public double overdraftCharge() {
        if (type.isPremium()) {
            double base = 10;
            if (daysOverdrawn > 7) {
                base += (daysOverdrawn - 7) * 0.85;
            }
            return base;
        }
        return daysOverdrawn * 1.75;
    }
}

package dk.sdu.refactoring.featureenvy.after;

public class AccountType {

    private final boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }

    // REFACTORING: Move Function (slide 34) - Account.overdraftCharge() -> AccountType.overdraftCharge(days)
    // The data it needed from Account (daysOverdrawn) is now passed as a parameter.
    public double overdraftCharge(int daysOverdrawn) {
        if (isPremium()) {
            double base = 10;
            if (daysOverdrawn > 7) {
                base += (daysOverdrawn - 7) * 0.85;
            }
            return base;
        }
        return daysOverdrawn * 1.75;
    }
}

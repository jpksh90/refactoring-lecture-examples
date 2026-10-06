package dk.sdu.refactoring.featureenvy.before;

public class AccountType {

    private final boolean premium;

    public AccountType(boolean premium) {
        this.premium = premium;
    }

    public boolean isPremium() {
        return premium;
    }
}

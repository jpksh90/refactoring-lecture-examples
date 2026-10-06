package dk.sdu.refactoring.featureenvy.after;

public class Invoice {

    // One clear call instead of reaching across into Account's data.
    public double bankCharge(Account account) {
        return account.bankCharge();
    }
}

package dk.sdu.refactoring.featureenvy.before;

/**
 * SMELL: Feature Envy (slides 35-36).
 * bankCharge() lives in Invoice but uses nothing of Invoice - it only
 * reaches into Account (daysOverdrawn, overdraftCharge).
 */
public class Invoice {

    public double bankCharge(Account account) {
        double result = 4.5;
        if (account.daysOverdrawn() > 0) {
            result += account.overdraftCharge();
        }
        return result;
    }
}

package dk.sdu.refactoring.mysteriousnames.after;

/**
 * REFACTORING: Rename Class  (Calc -> SavingsAccount)
 * The names now tell the story, so no comment is needed to explain the code.
 * In IntelliJ: Refactor | Rename (Shift+F6) updates every usage safely.
 */
public class SavingsAccount {

    // REFACTORING: Rename Field  (r -> annualInterestRate)
    private final double annualInterestRate;

    public SavingsAccount(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    // REFACTORING: Rename Function  (calc -> balanceAfterYears)
    // REFACTORING: Rename Parameter (a -> principal, n -> years)
    public double balanceAfterYears(double principal, int years) {
        double balance = principal;    // REFACTORING: Rename Variable (t -> balance)
        for (int year = 0; year < years; year++) {
            balance = balance + balance * annualInterestRate;
        }
        return balance;
    }
}

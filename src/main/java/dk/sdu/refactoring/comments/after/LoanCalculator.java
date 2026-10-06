package dk.sdu.refactoring.comments.after;

public class LoanCalculator {

    // REFACTORING: Change Function Declaration - calc(p, r, m) -> monthlyPayment(principal, annualRate, months)
    //   The name now says what the "// calculates the monthly payment" comment said.
    public double monthlyPayment(double principal, double annualRate, int months) {
        // REFACTORING: Introduce Assertion - the "r must be between 0 and 1" comment became
        //   an executable check (run with `java -ea` to enable assertions).
        assert annualRate > 0 && annualRate < 1 : "annualRate must be in (0, 1) but was " + annualRate;

        double monthlyRate = monthlyRate(annualRate);
        return roundToCents(annuity(principal, monthlyRate, months));
    }

    // REFACTORING: Extract Function - replaces "// convert yearly rate to monthly rate"
    private double monthlyRate(double annualRate) {
        return annualRate / 12;
    }

    // REFACTORING: Extract Function - replaces "// apply the annuity formula"
    // A comment that explains WHY stays: it carries knowledge the code cannot express.
    // Why the annuity formula: the bank requires equal instalments over the whole term.
    private double annuity(double principal, double monthlyRate, int months) {
        return principal * monthlyRate / (1 - Math.pow(1 + monthlyRate, -months));
    }

    // REFACTORING: Extract Function - replaces "// round to 2 decimals"
    private double roundToCents(double amount) {
        return Math.round(amount * 100) / 100.0;
    }
}

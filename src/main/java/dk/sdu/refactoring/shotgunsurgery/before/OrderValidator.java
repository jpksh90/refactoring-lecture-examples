package dk.sdu.refactoring.shotgunsurgery.before;

public class OrderValidator {

    public void validate(double netAmount) {
        double gross = netAmount * 1.25;                                     // SMELL: VAT rule copy #2
        if (gross > 10_000) {
            throw new IllegalArgumentException(
                    "Order too large: " + String.format("%.2f DKK", gross));   // SMELL: formatting copy #2
        }
    }
}

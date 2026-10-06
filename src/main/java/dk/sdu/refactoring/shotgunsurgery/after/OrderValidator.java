package dk.sdu.refactoring.shotgunsurgery.after;

public class OrderValidator {

    public void validate(double netAmount) {
        if (Pricing.exceedsLimit(netAmount)) {
            throw new IllegalArgumentException("Order too large: " + Pricing.format(Pricing.gross(netAmount)));
        }
    }
}

package dk.sdu.refactoring.lazyelements.after;

/**
 * REFACTORING: Inline Class - TrackingInformation was folded into Shipment.
 *  1. Move its fields into Shipment (Move Field).
 *  2. Move its methods into Shipment (Move Function).
 *  3. Delete the empty class.
 */
public class Shipment {

    private final String shippingCompany;
    private final String trackingNumber;

    public Shipment(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String trackingInfo() {
        return shippingCompany + ": " + trackingNumber;
    }
}

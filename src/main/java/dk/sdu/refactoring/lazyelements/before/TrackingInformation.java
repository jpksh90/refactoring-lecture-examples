package dk.sdu.refactoring.lazyelements.before;

/**
 * SMELL: Lazy Element (class) - after earlier refactorings this class has shrunk to
 * two fields and a getter. It no longer earns its place; only Shipment uses it.
 */
public class TrackingInformation {

    private final String shippingCompany;
    private final String trackingNumber;

    public TrackingInformation(String shippingCompany, String trackingNumber) {
        this.shippingCompany = shippingCompany;
        this.trackingNumber = trackingNumber;
    }

    public String display() {
        return shippingCompany + ": " + trackingNumber;
    }
}

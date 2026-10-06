package dk.sdu.refactoring.lazyelements.before;

public class Shipment {

    private final TrackingInformation trackingInformation;

    public Shipment(String shippingCompany, String trackingNumber) {
        this.trackingInformation = new TrackingInformation(shippingCompany, trackingNumber);
    }

    public String trackingInfo() {
        return trackingInformation.display();
    }
}

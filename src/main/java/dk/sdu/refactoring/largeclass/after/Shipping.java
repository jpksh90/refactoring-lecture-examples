package dk.sdu.refactoring.largeclass.after;

import java.util.List;

/** REFACTORING: Extract Class - "Shipping" (Move Field + Move Function for all shipping* members). */
public class Shipping {

    private String address;
    private String carrier;
    private final double ratePerKg = 4.0;

    public void setAddress(String address) { this.address = address; }

    public void setCarrier(String carrier) { this.carrier = carrier; }

    public double totalWeight(List<Item> items) {
        double w = 0;
        for (Item i : items) w += i.weightKg();
        return w;
    }

    public double cost(List<Item> items) { return totalWeight(items) * ratePerKg; }

    public String label(String customer) { return carrier + " -> " + customer + ", " + address; }
}

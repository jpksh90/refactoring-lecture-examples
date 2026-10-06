package dk.sdu.refactoring.largeclass.after;

import java.util.List;

/**
 * REFACTORING: Extract Class - "Billing".
 *  1. Create the class and link it from the old one.
 *  2. Move Field for each billing* field (dropping the now-redundant prefix: Rename Field).
 *  3. Move Function for each billing method.
 */
public class Billing {

    private String address;
    private final double vatRate = 0.25;
    private double discount;

    public void setAddress(String address) { this.address = address; }

    public String address() { return address; }

    public void setDiscount(double discount) { this.discount = discount; }

    public double netTotal(List<Item> items) {
        double sum = 0;
        for (Item i : items) sum += i.price();
        return sum - discount;
    }

    public double grossTotal(List<Item> items) { return netTotal(items) * (1 + vatRate); }
}

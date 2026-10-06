package dk.sdu.refactoring.largeclass.before;

import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Large Class (slide 47).
 * One class accumulates fields and behaviour for billing, shipping AND reporting.
 * Hint for finding the split: look at which fields are used together, and at
 * common prefixes/suffixes in field names (billing*, shipping*).
 */
public class OrderManager {

    private final String customer;
    private final List<Item> items = new ArrayList<>();

    // --- billing fields ---
    private String billingAddress;
    private double billingVatRate = 0.25;
    private double billingDiscount;

    // --- shipping fields ---
    private String shippingAddress;
    private String shippingCarrier;
    private double shippingRatePerKg = 4.0;

    // --- reporting fields ---
    private final List<String> reportLog = new ArrayList<>();

    public OrderManager(String customer) {
        this.customer = customer;
    }

    public void addItem(Item item) { items.add(item); }

    // --- billing behaviour ---
    public void setBillingAddress(String a) { billingAddress = a; }
    public void setBillingDiscount(double d) { billingDiscount = d; }

    public double netTotal() {
        double sum = 0;
        for (Item i : items) sum += i.price();
        return sum - billingDiscount;
    }

    public double grossTotal() { return netTotal() * (1 + billingVatRate); }

    // --- shipping behaviour ---
    public void setShippingAddress(String a) { shippingAddress = a; }
    public void setShippingCarrier(String c) { shippingCarrier = c; }

    public double totalWeight() {
        double w = 0;
        for (Item i : items) w += i.weightKg();
        return w;
    }

    public double shippingCost() { return totalWeight() * shippingRatePerKg; }

    public String shippingLabel() { return shippingCarrier + " -> " + customer + ", " + shippingAddress; }

    // --- reporting behaviour ---
    public String report() {
        reportLog.add("report generated for " + customer);
        return "Order for " + customer + "\n"
             + "  invoice to : " + billingAddress + "\n"
             + "  gross total: " + grossTotal() + "\n"
             + "  shipping   : " + shippingCost() + " (" + shippingLabel() + ")";
    }
}

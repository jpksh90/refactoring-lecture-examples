package dk.sdu.refactoring.largeclass.after;

import java.util.ArrayList;
import java.util.List;

/**
 * After Extract Class, Order only holds the core: who ordered what.
 * The responsibilities live in cohesive classes: Billing, Shipping, OrderReport.
 */
public class Order {

    private final String customer;
    private final List<Item> items = new ArrayList<>();
    private final Billing billing = new Billing();       // REFACTORING: Extract Class
    private final Shipping shipping = new Shipping();    // REFACTORING: Extract Class

    public Order(String customer) {
        this.customer = customer;
    }

    public void addItem(Item item) { items.add(item); }

    public String customer() { return customer; }

    public List<Item> items() { return List.copyOf(items); }

    public Billing billing() { return billing; }

    public Shipping shipping() { return shipping; }
}

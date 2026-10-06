package dk.sdu.refactoring.largeclass.after;

import java.util.ArrayList;
import java.util.List;

/**
 * REFACTORING: Extract Class - "Reporting".
 * Reporting is a client of Order rather than part of it, so it can change
 * (PDF, JSON, ...) without touching the domain classes.
 */
public class OrderReport {

    private final List<String> log = new ArrayList<>();

    public String render(Order order) {
        log.add("report generated for " + order.customer());
        List<Item> items = order.items();
        return "Order for " + order.customer() + "\n"
             + "  invoice to : " + order.billing().address() + "\n"
             + "  gross total: " + order.billing().grossTotal(items) + "\n"
             + "  shipping   : " + order.shipping().cost(items)
             + " (" + order.shipping().label(order.customer()) + ")";
    }
}

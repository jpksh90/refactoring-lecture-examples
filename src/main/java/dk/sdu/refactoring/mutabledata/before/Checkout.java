package dk.sdu.refactoring.mutabledata.before;

import java.util.ArrayList;
import java.util.List;

/** SMELL: related calculations are interleaved with unrelated side effects (slides 26-27). */
public class Checkout {

    private final List<String> log = new ArrayList<>();

    public double finish(double basePrice, double rate, String customer) {
        double base = basePrice;
        audit(customer);                       // SMELL: unrelated statement splits the calculation
        double discount = base * rate;
        double total = base - discount;
        notifyCustomer(customer, total);
        return total;
    }

    private void audit(String customer) { log.add("audit " + customer); }

    private void notifyCustomer(String customer, double total) {
        System.out.println("Dear " + customer + ", you pay " + total);
    }
}

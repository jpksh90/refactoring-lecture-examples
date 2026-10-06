package dk.sdu.refactoring.mutabledata.after;

import java.util.ArrayList;
import java.util.List;

public class Checkout {

    private final List<String> log = new ArrayList<>();

    public double finish(double basePrice, double rate, String customer) {
        // REFACTORING: Slide Statements - audit(..) was moved below the calculation
        //   (safe: audit does not read or write base/discount/total)
        // REFACTORING: Extract Function - the now-contiguous calculation got a name
        double total = discountedTotal(basePrice, rate);
        audit(customer);
        notifyCustomer(customer, total);
        return total;
    }

    private double discountedTotal(double base, double rate) {
        double discount = base * rate;
        return base - discount;
    }

    private void audit(String customer) { log.add("audit " + customer); }

    private void notifyCustomer(String customer, double total) {
        System.out.println("Dear " + customer + ", you pay " + total);
    }
}

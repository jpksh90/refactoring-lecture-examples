package dk.sdu.refactoring.longparameterlist.after;

/**
 * cost(customer, customerName, country, weightKg, baseCost, express)
 *   -> standardCost(customer, weightKg) / expressCost(customer, weightKg)
 */
public class ShippingService {

    // REFACTORING: Remove Flag Argument - one explicit function per behaviour instead of "express"
    public double standardCost(Customer customer, double weightKg) {
        return cost(customer, weightKg, 1);
    }

    public double expressCost(Customer customer, double weightKg) {
        return cost(customer, weightKg, 2);
    }

    // REFACTORING: Preserve Whole Object - pass the Customer, not values extracted from it
    private double cost(Customer customer, double weightKg, int speedFactor) {
        double cost = baseCost(weightKg);
        if (!customer.country().equals("DK")) {
            cost += 50;
        }
        cost *= speedFactor;
        System.out.println("Shipping for " + customer.name() + ": " + cost);
        return cost;
    }

    // REFACTORING: Replace Parameter with Query - baseCost is derived, so the callee computes it
    private double baseCost(double weightKg) {
        return weightKg * 10;
    }
}

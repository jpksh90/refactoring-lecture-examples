package dk.sdu.refactoring.longparameterlist.before;

/**
 * SMELL: Long Parameter List (slide 17).
 *   - customerName and country are pulled out of a Customer the caller already has
 *   - baseCost can be derived from weightKg
 *   - the boolean "express" is a flag argument: the caller must remember what "true" means
 */
public class ShippingService {

    public double cost(Customer customer, String customerName, String country,
                       double weightKg, double baseCost, boolean express) {
        double cost = baseCost;
        if (!country.equals("DK")) {
            cost += 50;
        }
        if (express) {
            cost *= 2;
        }
        System.out.println("Shipping for " + customerName + ": " + cost);
        return cost;
    }
}

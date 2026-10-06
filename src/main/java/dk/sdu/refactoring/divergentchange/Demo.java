package dk.sdu.refactoring.divergentchange;

import dk.sdu.refactoring.divergentchange.after.*;

/** Divergent Change -> Extract Class, Move Function, Split Phase. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- before ---");
        var module = new dk.sdu.refactoring.divergentchange.before.CustomerModule();
        module.save("c1", "Alice", 4);
        System.out.println(module.renderHtml("c1"));
        System.out.println(new dk.sdu.refactoring.divergentchange.before.PriceCalculator().priceOrder(
                new dk.sdu.refactoring.divergentchange.before.Product("Wine", 20), 10,
                new dk.sdu.refactoring.divergentchange.before.ShippingMethod(150, 1, 3)));

        System.out.println("--- after ---");
        var repo = new CustomerRepository();
        repo.save(new Customer("c1", "Alice", 4));
        var view = new CustomerView(new LoyaltyPolicy());
        System.out.println(view.renderHtml(repo.load("c1")));
        System.out.println(new PriceCalculator().priceOrder(
                new Product("Wine", 20), 10, new ShippingMethod(150, 1, 3)));
    }
}

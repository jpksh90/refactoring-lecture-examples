package dk.sdu.refactoring.largeclass;

/**
 * Large Class -> Extract Class (also: Extract Superclass / Subclass, and
 * "follow client usage" - clients that only use a subset of features reveal a class to extract).
 */
public class Demo {
    public static void main(String[] args) {
        var before = new dk.sdu.refactoring.largeclass.before.OrderManager("Alice");
        before.addItem(new dk.sdu.refactoring.largeclass.before.Item("Desk", 1000, 20));
        before.addItem(new dk.sdu.refactoring.largeclass.before.Item("Lamp", 200, 2));
        before.setBillingAddress("Campusvej 55");
        before.setBillingDiscount(100);
        before.setShippingAddress("Niels Bohrs Alle 1");
        before.setShippingCarrier("PostNord");
        System.out.println("--- before ---\n" + before.report());

        var after = new dk.sdu.refactoring.largeclass.after.Order("Alice");
        after.addItem(new dk.sdu.refactoring.largeclass.after.Item("Desk", 1000, 20));
        after.addItem(new dk.sdu.refactoring.largeclass.after.Item("Lamp", 200, 2));
        after.billing().setAddress("Campusvej 55");
        after.billing().setDiscount(100);
        after.shipping().setAddress("Niels Bohrs Alle 1");
        after.shipping().setCarrier("PostNord");
        System.out.println("--- after ---\n" + new dk.sdu.refactoring.largeclass.after.OrderReport().render(after));
    }
}

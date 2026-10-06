package dk.sdu.refactoring.globaldata;

/** Global Data -> Encapsulate Variable. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- before ---");
        var ordersBefore = new dk.sdu.refactoring.globaldata.before.OrderService();
        System.out.println(ordersBefore.createOrder("Laptop"));
        new dk.sdu.refactoring.globaldata.before.AdminTool().switchOwner("Maria");
        System.out.println(ordersBefore.createOrder("Laptop"));

        System.out.println("--- after ---");
        var ordersAfter = new dk.sdu.refactoring.globaldata.after.OrderService();
        System.out.println(ordersAfter.createOrder("Laptop"));
        new dk.sdu.refactoring.globaldata.after.AdminTool().switchOwner("Maria");
        System.out.println(ordersAfter.createOrder("Laptop"));
    }
}

package dk.sdu.refactoring.lazyelements;

/** Lazy Elements -> Inline Function, Inline Class, Collapse Hierarchy. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("before: rating=" + new dk.sdu.refactoring.lazyelements.before.Driver(7).rating()
                + ", " + new dk.sdu.refactoring.lazyelements.before.Shipment("GLS", "123").trackingInfo()
                + ", " + new dk.sdu.refactoring.lazyelements.before.Salesman("Eva").name());
        System.out.println("after : rating=" + new dk.sdu.refactoring.lazyelements.after.Driver(7).rating()
                + ", " + new dk.sdu.refactoring.lazyelements.after.Shipment("GLS", "123").trackingInfo()
                + ", " + new dk.sdu.refactoring.lazyelements.after.Employee("Eva").name());
    }
}

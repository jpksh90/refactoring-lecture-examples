package dk.sdu.refactoring.primitiveobsession;

import dk.sdu.refactoring.primitiveobsession.after.*;

/** Primitive Obsession -> Replace Primitive with Object, Replace Type Code with Subclasses, Replace Conditional with Polymorphism. */
public class Demo {
    public static void main(String[] args) {
        var before = new dk.sdu.refactoring.primitiveobsession.before.Customer(
                "Alice", "12-34-56-78", "dkk", dk.sdu.refactoring.primitiveobsession.before.Customer.GOLD);
        System.out.println("before: " + before.formattedPhone() + " | " + before.price(100));
        // Nothing stops this - and it will only fail (or misbehave) much later:
        new dk.sdu.refactoring.primitiveobsession.before.Customer("Bob", "n/a", "kroner", 7);

        var after = new Customer("Alice", new PhoneNumber("12-34-56-78"), new Currency("dkk"), CustomerType.GOLD);
        System.out.println("after : " + after.formattedPhone() + " | " + after.price(100));
        try {
            new PhoneNumber("n/a");
        } catch (IllegalArgumentException e) {
            System.out.println("after : invalid value rejected immediately -> " + e.getMessage());
        }
    }
}

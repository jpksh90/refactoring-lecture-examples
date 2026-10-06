package dk.sdu.refactoring.temporaryfield;

import dk.sdu.refactoring.temporaryfield.after.MadeToOrder;

/** Temporary Field -> Extract Class. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("before: " + new dk.sdu.refactoring.temporaryfield.before.Order(10, 2).shippingWeight()
                + " / " + new dk.sdu.refactoring.temporaryfield.before.Order(2, 3, 4).shippingWeight());
        System.out.println("after : " + new dk.sdu.refactoring.temporaryfield.after.Order(10, 2).shippingWeight()
                + " / " + new dk.sdu.refactoring.temporaryfield.after.Order(2, new MadeToOrder(3, 4)).shippingWeight());
    }
}

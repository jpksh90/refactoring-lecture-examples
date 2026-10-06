package dk.sdu.refactoring.globaldata.after;

import java.util.Objects;

/**
 * REFACTORING: Encapsulate Variable (slides 20 + 22).
 *  1. Create getter/setter functions for the variable.
 *  2. Replace every direct reference with a call to them.
 *  3. Restrict the visibility of the variable (public -> private).
 * Now there is ONE access path that can validate, log and control every change.
 */
public class Defaults {

    private static Customer defaultOwnerData = new Customer("Ivan");

    public static Customer defaultOwner() {
        return defaultOwnerData;
    }

    public static void setDefaultOwner(Customer customer) {
        // Because all writes go through here, we can now add a guard in one place.
        defaultOwnerData = Objects.requireNonNull(customer, "default owner must not be null");
    }
}

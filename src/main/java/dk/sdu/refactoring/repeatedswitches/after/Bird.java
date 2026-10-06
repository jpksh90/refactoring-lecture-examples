package dk.sdu.refactoring.repeatedswitches.after;

import java.util.Locale;

/**
 * REFACTORING: Replace Conditional with Polymorphism (slides 40-41).
 *  1. Create a subclass for each case of the switch (Replace Type Code with Subclasses).
 *  2. Use a factory function to create the right subclass.
 *  3. Move each switch branch into an overriding method in the matching subclass.
 *  4. Make the base method abstract once all branches are moved.
 * Adding a new bird type no longer requires editing the original conditional.
 */
public abstract class Bird {

    // REFACTORING: Replace Constructor with Factory Function - the only place that still "switches"
    public static Bird create(String type, int coconuts, double voltage, boolean isNailed) {
        return switch (type.toUpperCase(Locale.ROOT)) {
            case "EUROPEAN" -> new European();
            case "AFRICAN" -> new African(coconuts);
            case "NORWEGIAN_BLUE" -> new NorwegianBlue(voltage, isNailed);
            default -> throw new IllegalArgumentException("unknown type " + type);
        };
    }

    public abstract double getSpeed();

    public String plumage() {
        return "average";          // the common case lives in the superclass
    }

    protected double baseSpeed() { return 12; }
}

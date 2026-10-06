package dk.sdu.refactoring.repeatedswitches;

import dk.sdu.refactoring.repeatedswitches.after.Bird;
import dk.sdu.refactoring.repeatedswitches.before.BirdType;

/** Repeated Switches -> Replace Conditional with Polymorphism (+ Replace Type Code with Subclasses). */
public class Demo {
    public static void main(String[] args) {
        for (BirdType type : BirdType.values()) {
            var before = new dk.sdu.refactoring.repeatedswitches.before.Bird(type, 3, 150, false);
            Bird after = Bird.create(type.name(), 3, 150, false);
            System.out.printf("%-15s before: %5.1f %-9s | after: %5.1f %-9s (%s)%n", type,
                    before.getSpeed(), before.plumage(), after.getSpeed(), after.plumage(),
                    after.getClass().getSimpleName());
        }
    }
}

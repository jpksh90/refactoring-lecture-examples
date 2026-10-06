package dk.sdu.refactoring.refusedbequest.after;

import java.util.ArrayList;
import java.util.List;

/**
 * REFACTORING: Replace Superclass with Delegate (slide 54).
 *  1. Add a field holding an instance of the old superclass (the delegate).
 *  2. For each superclass method clients really need, write a forwarding method.
 *  3. Remove "extends ArrayList".
 * The relationship changes from "is-a" to "has-a"; only stack operations are exposed.
 */
public class Stack {

    private final List<String> elements = new ArrayList<>();

    public void push(String item) {
        elements.add(item);
    }

    public String pop() {
        return elements.remove(elements.size() - 1);
    }

    public int size() {                    // forwarded only because clients need it
        return elements.size();
    }
}

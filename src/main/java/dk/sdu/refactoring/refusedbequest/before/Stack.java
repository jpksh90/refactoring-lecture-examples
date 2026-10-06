package dk.sdu.refactoring.refusedbequest.before;

import java.util.ArrayList;

/**
 * SMELL: Refused Bequest via a wrong superclass (slide 54).
 * A Stack "is-a" ArrayList, so it inherits the full List API: callers can
 * add(0, x), remove(3), sort(...) - and silently break the LIFO promise.
 */
@SuppressWarnings("serial")
public class Stack extends ArrayList<String> {

    public void push(String item) {
        add(item);
    }

    public String pop() {
        return remove(size() - 1);
    }
}

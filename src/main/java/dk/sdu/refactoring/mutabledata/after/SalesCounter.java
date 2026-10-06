package dk.sdu.refactoring.mutabledata.after;

/**
 * REFACTORING: Separate Query from Modifier (slide 24).
 * total() is side-effect free and safe to call any number of times;
 * reset() makes the state change explicit at the call site.
 */
public class SalesCounter {

    private int total;

    public void record(int amount) { total += amount; }

    public int total() {             // query: no side effects
        return total;
    }

    public void reset() {            // modifier: no return value
        total = 0;
    }
}

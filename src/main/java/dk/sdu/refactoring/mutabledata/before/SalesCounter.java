package dk.sdu.refactoring.mutabledata.before;

/** SMELL: hidden side effect - a function that looks like a query also changes state (slide 24). */
public class SalesCounter {

    private int total;

    public void record(int amount) { total += amount; }

    public int totalAndReset() {     // SMELL: calling it twice gives different answers
        int result = total;
        total = 0;
        return result;
    }
}

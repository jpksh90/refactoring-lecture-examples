package dk.sdu.refactoring.divergentchange.before;

import java.util.HashMap;
import java.util.Map;

/**
 * SMELL: Divergent Change (slide 31).
 * This one class changes for three unrelated reasons:
 *   - the database / storage changes          -> save(), load()
 *   - a business rule changes (loyalty rules) -> discountRate()
 *   - the UI changes (HTML -> JSON, styling)  -> renderHtml()
 * Every change risks disturbing unrelated behaviour.
 */
public class CustomerModule {

    // "database" - in a real system this would be JDBC/JPA code
    private final Map<String, String[]> table = new HashMap<>();

    // --- data access concern ---
    public void save(String id, String name, int yearsAsCustomer) {
        table.put(id, new String[]{name, String.valueOf(yearsAsCustomer)});
    }

    public String[] load(String id) {
        return table.get(id);
    }

    // --- business rule concern ---
    public double discountRate(String id) {
        int years = Integer.parseInt(load(id)[1]);
        if (years >= 10) return 0.15;
        if (years >= 3) return 0.05;
        return 0.0;
    }

    // --- presentation concern ---
    public String renderHtml(String id) {
        String[] row = load(id);
        return "<div class='customer'><b>" + row[0] + "</b> - discount "
                + (int) (discountRate(id) * 100) + "%</div>";
    }
}

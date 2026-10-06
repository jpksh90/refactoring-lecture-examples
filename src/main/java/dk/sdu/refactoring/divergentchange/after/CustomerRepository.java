package dk.sdu.refactoring.divergentchange.after;

import java.util.HashMap;
import java.util.Map;

/**
 * REFACTORING: Extract Class + Move Function (slide 31) - "Data access".
 * A database change now touches only this class.
 */
public class CustomerRepository {

    private final Map<String, Customer> table = new HashMap<>();   // REFACTORING: Move Field

    public void save(Customer customer) {
        table.put(customer.id(), customer);
    }

    public Customer load(String id) {
        return table.get(id);
    }
}

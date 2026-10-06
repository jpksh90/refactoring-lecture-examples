package dk.sdu.refactoring.messagechains.before;

/**
 * SMELL: Message Chains (slides 44, 48).
 * The client navigates Employee -> Department -> Manager. It now depends on the
 * structure of the whole chain: if managers move from Department to e.g. Team,
 * every client with this chain breaks.
 */
public class LeaveRequestService {

    public String submit(Employee employee, int days) {
        Person manager = employee.getDepartment().getManager();      // SMELL: message chain
        return employee.getName() + " asks " + manager.name() + " for " + days + " days off";
    }
}

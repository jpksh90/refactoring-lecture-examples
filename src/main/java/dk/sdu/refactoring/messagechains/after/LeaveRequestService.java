package dk.sdu.refactoring.messagechains.after;

public class LeaveRequestService {

    public String submit(Employee employee, int days) {
        Person manager = employee.manager();      // REFACTORING: Hide Delegate - no chain
        return employee.getName() + " asks " + manager.name() + " for " + days + " days off";
    }
}

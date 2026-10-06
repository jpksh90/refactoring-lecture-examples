package dk.sdu.refactoring.loops.before;

import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Loops (slides 42-43).
 * Each loop spells out the mechanics (create list, iterate, test, add, accumulate)
 * rather than the purpose. The reader must simulate the loop to know what it computes.
 */
public class EmployeeReport {

    public List<String> highEarnerNames(List<Employee> employees) {
        List<String> names = new ArrayList<>();
        for (Employee e : employees) {
            if (e.salary() > 100000) {
                names.add(e.name());
            }
        }
        return names;
    }

    public double averageSalaryIn(List<Employee> employees, String department) {
        double total = 0;
        int count = 0;
        for (Employee e : employees) {
            if (e.department().equals(department)) {
                total += e.salary();
                count++;
            }
        }
        return count == 0 ? 0 : total / count;
    }

    public List<String> departments(List<Employee> employees) {
        List<String> result = new ArrayList<>();
        for (Employee e : employees) {
            if (!result.contains(e.department())) {
                result.add(e.department());
            }
        }
        result.sort(null);
        return result;
    }
}

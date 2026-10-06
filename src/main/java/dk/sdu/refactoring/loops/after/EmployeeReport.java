package dk.sdu.refactoring.loops.after;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REFACTORING: Replace Loop with Pipeline (slide 43).
 *  1. Create a stream from the loop's collection.
 *  2. Move each piece of loop behaviour into a pipeline operation
 *     (if -> filter, transformation -> map, accumulation -> collect / reduce).
 *  3. Delete the loop.
 * filter selects records, map changes their form, collect materialises the result.
 */
public class EmployeeReport {

    public List<String> highEarnerNames(List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.salary() > 100000)     // was: if (...)
                .map(Employee::name)                  // was: names.add(e.name())
                .collect(Collectors.toList());        // was: new ArrayList<>() + return
    }

    public double averageSalaryIn(List<Employee> employees, String department) {
        return employees.stream()
                .filter(e -> e.department().equals(department))
                .mapToDouble(Employee::salary)
                .average()                            // was: total / count, with a zero check
                .orElse(0);
    }

    public List<String> departments(List<Employee> employees) {
        return employees.stream()
                .map(Employee::department)
                .distinct()                           // was: if (!result.contains(..))
                .sorted()                             // was: result.sort(null)
                .collect(Collectors.toList());
    }
}

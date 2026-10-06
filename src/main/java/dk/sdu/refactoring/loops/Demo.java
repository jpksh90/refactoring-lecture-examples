package dk.sdu.refactoring.loops;

import java.util.List;

/** Loops -> Replace Loop with Pipeline. */
public class Demo {
    public static void main(String[] args) {
        var b = List.of(
                new dk.sdu.refactoring.loops.before.Employee("Ana", "R&D", 120000),
                new dk.sdu.refactoring.loops.before.Employee("Ben", "Sales", 80000),
                new dk.sdu.refactoring.loops.before.Employee("Cai", "R&D", 95000));
        var a = List.of(
                new dk.sdu.refactoring.loops.after.Employee("Ana", "R&D", 120000),
                new dk.sdu.refactoring.loops.after.Employee("Ben", "Sales", 80000),
                new dk.sdu.refactoring.loops.after.Employee("Cai", "R&D", 95000));
        var rb = new dk.sdu.refactoring.loops.before.EmployeeReport();
        var ra = new dk.sdu.refactoring.loops.after.EmployeeReport();
        System.out.println("before: " + rb.highEarnerNames(b) + " " + rb.averageSalaryIn(b, "R&D") + " " + rb.departments(b));
        System.out.println("after : " + ra.highEarnerNames(a) + " " + ra.averageSalaryIn(a, "R&D") + " " + ra.departments(a));
    }
}

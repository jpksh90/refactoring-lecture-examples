package dk.sdu.refactoring.middleman;

/** Middle Man -> Remove Middle Man. */
public class Demo {
    public static void main(String[] args) {
        var pb = new dk.sdu.refactoring.middleman.before.Person("Ole",
                new dk.sdu.refactoring.middleman.before.Department("IMADA", "Mette", 1_000_000, "Campusvej 55"));
        System.out.println("before: " + pb.departmentCode() + ", " + pb.manager() + ", "
                + pb.departmentBudget() + ", " + pb.building());

        var pa = new dk.sdu.refactoring.middleman.after.Person("Ole",
                new dk.sdu.refactoring.middleman.after.Department("IMADA", "Mette", 1_000_000, "Campusvej 55"));
        var dept = pa.department();     // client talks to the real object directly
        System.out.println("after : " + dept.code() + ", " + dept.manager() + ", "
                + dept.budget() + ", " + dept.building());
    }
}

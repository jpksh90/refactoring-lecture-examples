package dk.sdu.refactoring.messagechains;

/** Message Chains -> Hide Delegate. */
public class Demo {
    public static void main(String[] args) {
        var eb = new dk.sdu.refactoring.messagechains.before.Employee("Ole",
                new dk.sdu.refactoring.messagechains.before.Department("IMADA",
                        new dk.sdu.refactoring.messagechains.before.Person("Mette")));
        var ea = new dk.sdu.refactoring.messagechains.after.Employee("Ole",
                new dk.sdu.refactoring.messagechains.after.Department("IMADA",
                        new dk.sdu.refactoring.messagechains.after.Person("Mette")));
        System.out.println("before: " + new dk.sdu.refactoring.messagechains.before.LeaveRequestService().submit(eb, 3));
        System.out.println("after : " + new dk.sdu.refactoring.messagechains.after.LeaveRequestService().submit(ea, 3));
    }
}

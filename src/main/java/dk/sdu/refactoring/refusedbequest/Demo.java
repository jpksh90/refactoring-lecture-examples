package dk.sdu.refactoring.refusedbequest;

/** Refused Bequest -> Push Down Method / Field, Replace Superclass (or Subclass) with Delegate. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- before ---");
        dk.sdu.refactoring.refusedbequest.before.Employee e = new dk.sdu.refactoring.refusedbequest.before.Engineer("Lars");
        try {
            e.quota();                 // compiles, but blows up at runtime
        } catch (UnsupportedOperationException ex) {
            System.out.println("Engineer.quota(): " + ex.getMessage());
        }
        System.out.println("Salesperson quota: " + new dk.sdu.refactoring.refusedbequest.before.Salesperson("Kim", 1000).quota());
        var s1 = new dk.sdu.refactoring.refusedbequest.before.Stack();
        s1.push("a");
        s1.push("b");
        s1.add(0, "sneaky");           // inherited List API bypasses the stack
        System.out.println("pop: " + s1.pop() + ", contents: " + s1);

        System.out.println("--- after ---");
        // new Engineer("Lars").quota();  <- no longer compiles: the mistake is caught at compile time
        System.out.println("Salesperson quota: " + new dk.sdu.refactoring.refusedbequest.after.Salesperson("Kim", 1000).quota());
        var s2 = new dk.sdu.refactoring.refusedbequest.after.Stack();
        s2.push("a");
        s2.push("b");
        // s2.add(0, "sneaky");         <- no longer compiles
        System.out.println("pop: " + s2.pop() + ", size: " + s2.size());
    }
}

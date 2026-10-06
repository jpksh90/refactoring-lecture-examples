package dk.sdu.refactoring.speculativegenerality;

/**
 * Speculative Generality -> Collapse Hierarchy, Inline Function/Class,
 * Change Function Declaration (unused parameters), Remove Dead Code.
 */
public class Demo {
    public static void main(String[] args) {
        System.out.println("before: " + new dk.sdu.refactoring.speculativegenerality.before.NotificationService().welcome("a@sdu.dk"));
        System.out.println("after : " + new dk.sdu.refactoring.speculativegenerality.after.NotificationService().welcome("a@sdu.dk"));
    }
}

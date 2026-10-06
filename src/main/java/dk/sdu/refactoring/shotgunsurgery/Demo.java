package dk.sdu.refactoring.shotgunsurgery;

/** Shotgun Surgery -> Move Function, Move Field, Combine Functions into Class. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("--- before ---");
        System.out.println(new dk.sdu.refactoring.shotgunsurgery.before.CheckoutController().checkout(400));
        System.out.println("--- after ---");
        System.out.println(new dk.sdu.refactoring.shotgunsurgery.after.CheckoutController().checkout(400));
    }
}

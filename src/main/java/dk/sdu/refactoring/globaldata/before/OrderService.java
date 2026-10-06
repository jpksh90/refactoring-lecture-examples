package dk.sdu.refactoring.globaldata.before;

/** "Module A" - reads the global directly. */
public class OrderService {

    public String createOrder(String item) {
        return item + " ordered by " + Defaults.defaultOwner.name();
    }
}

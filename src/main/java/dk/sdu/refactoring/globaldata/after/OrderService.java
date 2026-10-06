package dk.sdu.refactoring.globaldata.after;

public class OrderService {

    public String createOrder(String item) {
        // REFACTORING: Encapsulate Variable - read goes through the getter
        return item + " ordered by " + Defaults.defaultOwner().name();
    }
}

package dk.sdu.refactoring.globaldata.after;

public class AdminTool {

    public void switchOwner(String newName) {
        // REFACTORING: Encapsulate Variable - write goes through the setter
        Defaults.setDefaultOwner(new Customer(newName));
    }
}

package dk.sdu.refactoring.globaldata.before;

/** "Module B" - writes the global directly. Nothing stops it from writing null. */
public class AdminTool {

    public void switchOwner(String newName) {
        Defaults.defaultOwner = new Customer(newName);   // SMELL: uncontrolled mutation
    }
}

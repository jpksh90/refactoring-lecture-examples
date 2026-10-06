package dk.sdu.refactoring.globaldata.before;

/**
 * SMELL: Global Data (slides 19-20).
 * A public static, non-final field: any class anywhere can read AND overwrite it.
 * When the value is wrong, there is no single place to set a breakpoint or add a check.
 */
public class Defaults {

    public static Customer defaultOwner = new Customer("Ivan");
}

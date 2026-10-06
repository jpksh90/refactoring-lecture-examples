package dk.sdu.refactoring.featureenvy;

/** Feature Envy -> Move Function (move behaviour closer to the data it uses). */
public class Demo {
    public static void main(String[] args) {
        for (boolean premium : new boolean[]{true, false}) {
            var before = new dk.sdu.refactoring.featureenvy.before.Account(
                    new dk.sdu.refactoring.featureenvy.before.AccountType(premium), 10);
            var after = new dk.sdu.refactoring.featureenvy.after.Account(
                    new dk.sdu.refactoring.featureenvy.after.AccountType(premium), 10);
            System.out.println("premium=" + premium
                    + "  before: " + new dk.sdu.refactoring.featureenvy.before.Invoice().bankCharge(before)
                    + "  after: " + new dk.sdu.refactoring.featureenvy.after.Invoice().bankCharge(after));
        }
    }
}

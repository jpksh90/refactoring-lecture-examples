package dk.sdu.refactoring.mysteriousnames;

import dk.sdu.refactoring.mysteriousnames.after.SavingsAccount;
import dk.sdu.refactoring.mysteriousnames.before.Calc;

/** Mysterious Names -> Rename Function / Field / Variable. Both versions must print the same value. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("before: " + new Calc(0.05).calc(1000, 3));
        System.out.println("after : " + new SavingsAccount(0.05).balanceAfterYears(1000, 3));
    }
}

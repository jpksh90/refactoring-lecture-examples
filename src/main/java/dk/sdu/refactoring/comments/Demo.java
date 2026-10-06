package dk.sdu.refactoring.comments;

/** Comments -> Extract Function, Change Function Declaration, Introduce Assertion. */
public class Demo {
    public static void main(String[] args) {
        System.out.println("before: " + new dk.sdu.refactoring.comments.before.LoanCalculator().calc(200_000, 0.05, 120));
        System.out.println("after : " + new dk.sdu.refactoring.comments.after.LoanCalculator().monthlyPayment(200_000, 0.05, 120));
    }
}

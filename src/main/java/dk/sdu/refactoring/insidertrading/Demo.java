package dk.sdu.refactoring.insidertrading;

/** Insider Trading -> Move Function / Move Field, Encapsulate, Hide Delegate. */
public class Demo {
    public static void main(String[] args) {
        var lib = new dk.sdu.refactoring.insidertrading.before.Library();
        var bookB = new dk.sdu.refactoring.insidertrading.before.Book("Refactoring");
        lib.available.add(bookB);
        var memB = new dk.sdu.refactoring.insidertrading.before.Member("Sofie");
        lib.lend(bookB, memB);
        lib.returnBook(bookB, memB, 4);
        System.out.println("before: fines=" + memB.fines + " canBorrow=" + memB.canBorrow(lib));
        memB.fines = 0;   // compiles! any class can wipe a member's fines

        var libA = new dk.sdu.refactoring.insidertrading.after.Library();
        var bookA = new dk.sdu.refactoring.insidertrading.after.Book("Refactoring");
        libA.addBook(bookA);
        var memA = new dk.sdu.refactoring.insidertrading.after.Member("Sofie");
        libA.lend(bookA, memA);
        libA.returnBook(bookA, memA, 4);
        System.out.println("after : fines=" + memA.outstandingFines() + " canBorrow=" + libA.canLend(memA));
    }
}

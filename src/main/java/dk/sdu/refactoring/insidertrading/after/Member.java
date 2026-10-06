package dk.sdu.refactoring.insidertrading.after;

import java.util.ArrayList;
import java.util.List;

/**
 * Member now owns (and protects) its own data. Others must ask through its interface.
 */
public class Member {

    private final String name;                          // REFACTORING: Encapsulate Record / Variable
    private double fines;
    private final List<Book> borrowed = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }

    public String name() { return name; }

    public double outstandingFines() { return fines; }

    public int loanCount() { return borrowed.size(); }

    // REFACTORING: Move Function - the "add to my loans" step moved from Library into Member
    void borrow(Book book) {
        borrowed.add(book);
    }

    // REFACTORING: Move Function - Member now owns its own fine accounting
    void giveBack(Book book, double lateFee) {
        borrowed.remove(book);
        fines += lateFee;
    }
}

package dk.sdu.refactoring.insidertrading.after;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Library now owns the lending POLICY; Member owns the member's STATE.
 * Each module talks to the other only through a small, explicit interface.
 * (If the coupling came from a subclass poking into its superclass' protected fields,
 *  the slide's third option - Replace Superclass/Subclass with Delegate - would apply.)
 */
public class Library {

    private static final double LATE_FEE_PER_DAY = 2.0;

    private final double maxFines = 50;                      // REFACTORING: Encapsulate Variable (private)
    private final int loanLimit = 3;
    private final Set<String> blacklist = new HashSet<>();
    private final List<Book> available = new ArrayList<>();

    public void addBook(Book book) { available.add(book); }

    public void ban(String memberName) { blacklist.add(memberName); }

    // REFACTORING: Move Function - Member.canBorrow(library) -> Library.canLend(member)
    // It uses mostly Library data, so Library is its natural owner.
    public boolean canLend(Member member) {
        return member.outstandingFines() < maxFines
                && member.loanCount() < loanLimit
                && !blacklist.contains(member.name());
    }

    public void lend(Book book, Member member) {
        if (!canLend(member)) {
            throw new IllegalStateException(member.name() + " may not borrow");
        }
        available.remove(book);
        member.borrow(book);                       // asks, does not reach inside
    }

    public void returnBook(Book book, Member member, int daysLate) {
        member.giveBack(book, daysLate * LATE_FEE_PER_DAY);
        available.add(book);
    }
}

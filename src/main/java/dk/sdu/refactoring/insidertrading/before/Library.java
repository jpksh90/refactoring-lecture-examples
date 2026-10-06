package dk.sdu.refactoring.insidertrading.before;

import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;

public class Library {

    public double maxFines = 50;                        // SMELL: read by Member
    public int loanLimit = 3;                           // SMELL: read by Member
    public final Set<String> blacklist = new HashSet<>();   // SMELL: read by Member
    public final List<Book> available = new ArrayList<>();

    public void lend(Book book, Member member) {
        if (!member.canBorrow(this)) {
            throw new IllegalStateException(member.name + " may not borrow");
        }
        available.remove(book);
        member.borrowed.add(book);                      // SMELL: reaching inside Member
    }

    public void returnBook(Book book, Member member, int daysLate) {
        member.borrowed.remove(book);                   // SMELL: reaching inside Member
        member.fines += daysLate * 2.0;                 // SMELL: reaching inside Member
        available.add(book);
    }
}

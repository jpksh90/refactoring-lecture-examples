package dk.sdu.refactoring.insidertrading.before;

import java.util.ArrayList;
import java.util.List;

/**
 * SMELL: Insider Trading (slide 46).
 * Member and Library reach into each other's internals:
 *   - Library mutates Member.borrowed and Member.fines directly
 *   - Member reads Library.maxFines, Library.loanLimit and Library.blacklist directly
 * Ownership blurs: who is responsible for the lending rules? For the fine accounting?
 */
public class Member {

    public final String name;
    public double fines;                               // SMELL: written by Library
    public final List<Book> borrowed = new ArrayList<>();   // SMELL: mutated by Library

    public Member(String name) {
        this.name = name;
    }

    // SMELL: this is a LIBRARY policy, but it lives in Member and digs into Library's fields
    public boolean canBorrow(Library library) {
        return fines < library.maxFines
                && borrowed.size() < library.loanLimit
                && !library.blacklist.contains(name);
    }
}

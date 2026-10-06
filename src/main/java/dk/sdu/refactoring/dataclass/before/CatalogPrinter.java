package dk.sdu.refactoring.dataclass.before;

public class CatalogPrinter {

    public String line(Book book) {
        // SMELL: the same pricing formula duplicated in a second client
        double finalPrice = book.price * (1 - book.getDiscountRate());
        return book.title + " (ISBN " + book.getIsbn() + "): " + finalPrice;
    }
}

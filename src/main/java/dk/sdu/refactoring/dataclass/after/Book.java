package dk.sdu.refactoring.dataclass.after;

/**
 * The data class became a real object that owns its data AND its behaviour.
 */
public class Book {

    private final String title;      // REFACTORING: Encapsulate Record - public fields -> private
    private final String isbn;       // REFACTORING: Remove Setting Method - isbn set once, in the constructor
    private double price;
    private double discountRate;

    public Book(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.price = price;
    }

    public String title() { return title; }

    public String isbn() { return isbn; }

    public void changePrice(double newPrice) {
        if (newPrice < 0) throw new IllegalArgumentException("price must be >= 0");
        this.price = newPrice;
    }

    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }

    // REFACTORING: Move Function - PriceCalculator.finalPrice(book) -> Book.finalPrice()
    // (the duplicate in CatalogPrinter was first turned into a call via Extract Function)
    public double finalPrice() {
        return price * (1 - discountRate);
    }

    // REFACTORING: Move Function - formatting that only uses Book data
    public String catalogLine() {
        return title + " (ISBN " + isbn + "): " + finalPrice();
    }
}

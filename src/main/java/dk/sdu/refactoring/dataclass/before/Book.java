package dk.sdu.refactoring.dataclass.before;

/**
 * SMELL: Data Class (slide 49).
 * Only fields, getters and setters - a "dumb data holder".
 *  - public field: anyone can change the price, unchecked
 *  - setIsbn(): the ISBN is an identifier and should never change
 *  - the behaviour that uses this data lives in OTHER classes (see PriceCalculator, CatalogPrinter)
 */
public class Book {

    public String title;           // SMELL: public field
    public double price;           // SMELL: public field
    private String isbn;
    private double discountRate;

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) { this.isbn = isbn; }   // SMELL: identity should be constant

    public double getDiscountRate() { return discountRate; }

    public void setDiscountRate(double discountRate) { this.discountRate = discountRate; }
}

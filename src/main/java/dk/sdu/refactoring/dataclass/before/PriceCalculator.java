package dk.sdu.refactoring.dataclass.before;

/** SMELL (Feature Envy, caused by the Data Class): logic about a Book lives outside Book. */
public class PriceCalculator {

    public double finalPrice(Book book) {
        return book.price * (1 - book.getDiscountRate());
    }
}

package dk.sdu.refactoring.dataclass.after;

/**
 * PriceCalculator was deleted - its only method moved into Book.
 * NOTE (slide 49 exception): immutable result records, e.g. the PriceData produced by
 * Split Phase (package divergentchange), may legitimately stay "just data".
 */
public class CatalogPrinter {

    public String line(Book book) {
        return book.catalogLine();
    }
}

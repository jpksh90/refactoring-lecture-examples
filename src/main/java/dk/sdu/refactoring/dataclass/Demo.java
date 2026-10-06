package dk.sdu.refactoring.dataclass;

/** Data Class -> Encapsulate Record, Remove Setting Method, Move Function / Extract Function. */
public class Demo {
    public static void main(String[] args) {
        var b = new dk.sdu.refactoring.dataclass.before.Book();
        b.title = "Refactoring";
        b.price = 400;
        b.setIsbn("978-0134757599");
        b.setDiscountRate(0.1);
        System.out.println("before: " + new dk.sdu.refactoring.dataclass.before.CatalogPrinter().line(b)
                + " | " + new dk.sdu.refactoring.dataclass.before.PriceCalculator().finalPrice(b));

        var a = new dk.sdu.refactoring.dataclass.after.Book("Refactoring", "978-0134757599", 400);
        a.setDiscountRate(0.1);
        System.out.println("after : " + new dk.sdu.refactoring.dataclass.after.CatalogPrinter().line(a)
                + " | " + a.finalPrice());
    }
}

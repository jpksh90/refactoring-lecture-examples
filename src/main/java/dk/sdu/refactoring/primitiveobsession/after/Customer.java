package dk.sdu.refactoring.primitiveobsession.after;

/** Customer now speaks in domain types; it no longer knows how phones or currencies work. */
public class Customer {

    private final String name;
    private final PhoneNumber phoneNumber;   // REFACTORING: Replace Primitive with Object
    private final Currency currency;         // REFACTORING: Replace Primitive with Object
    private final CustomerType type;         // REFACTORING: Replace Type Code with Subclasses (enum)

    public Customer(String name, PhoneNumber phoneNumber, Currency currency, CustomerType type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.type = type;
    }

    // REFACTORING: Move Function - formatting moved into PhoneNumber
    public String formattedPhone() {
        return phoneNumber.formatted();
    }

    // REFACTORING: Replace Conditional with Polymorphism - each CustomerType knows its rate
    public double discountRate() {
        return type.discountRate();
    }

    public String price(double amount) {
        return (amount * (1 - discountRate())) + " " + currency;
    }

    public String name() { return name; }
}

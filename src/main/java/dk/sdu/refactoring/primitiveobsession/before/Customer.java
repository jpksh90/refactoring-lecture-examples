package dk.sdu.refactoring.primitiveobsession.before;

/**
 * SMELL: Primitive Obsession (slide 39).
 *  - String phoneNumber : only a string - no validation, formatting logic lives elsewhere
 *  - String currency    : only a string - "dkk", "DKK", "Kroner" are all "valid"
 *  - int type           : only a number - what is 2? what happens with 7?
 */
public class Customer {

    public static final int REGULAR = 0;    // SMELL: type code
    public static final int GOLD = 1;
    public static final int PLATINUM = 2;

    private final String name;
    private final String phoneNumber;
    private final String currency;
    private final int type;

    public Customer(String name, String phoneNumber, String currency, int type) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.currency = currency;
        this.type = type;
    }

    // SMELL: formatting rules for a phone number live in Customer
    public String formattedPhone() {
        String digits = phoneNumber.replaceAll("\\D", "");
        return "+45 " + digits.substring(0, 2) + " " + digits.substring(2, 4) + " "
                + digits.substring(4, 6) + " " + digits.substring(6, 8);
    }

    // SMELL: conditional on a type code (related smell: Repeated Switches)
    public double discountRate() {
        if (type == GOLD) return 0.10;
        if (type == PLATINUM) return 0.20;
        return 0.0;
    }

    public String price(double amount) {
        return (amount * (1 - discountRate())) + " " + currency.toUpperCase();
    }

    public String name() { return name; }
}

package dk.sdu.refactoring.primitiveobsession.after;

/**
 * REFACTORING: Replace Primitive with Object (String -> PhoneNumber).
 * Format and validation now belong to the type; an invalid PhoneNumber cannot exist.
 */
public record PhoneNumber(String digits) {

    public PhoneNumber {
        String onlyDigits = digits.replaceAll("\\D", "");
        if (onlyDigits.length() != 8) {
            throw new IllegalArgumentException("Danish phone numbers have 8 digits: '" + digits + "'");
        }
        digits = onlyDigits;
    }

    public String formatted() {
        return "+45 " + digits.substring(0, 2) + " " + digits.substring(2, 4) + " "
                + digits.substring(4, 6) + " " + digits.substring(6, 8);
    }
}

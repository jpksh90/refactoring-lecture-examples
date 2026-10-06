package dk.sdu.refactoring.primitiveobsession.after;

/**
 * REFACTORING: Replace Primitive with Object (String -> Currency).
 * Currency rules (3-letter ISO code, upper case) become explicit and are checked once.
 */
public record Currency(String code) {

    public Currency {
        code = code.toUpperCase();
        if (!code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Not an ISO-4217 code: " + code);
        }
    }

    @Override
    public String toString() {
        return code;
    }
}

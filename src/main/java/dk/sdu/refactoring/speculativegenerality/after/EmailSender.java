package dk.sdu.refactoring.speculativegenerality.after;

/**
 * REFACTORING: Collapse Hierarchy - AbstractNotificationSender merged into its only subclass.
 * REFACTORING: Change Function Declaration - unused parameters (options, priority) removed.
 * REFACTORING: Remove Dead Code - formatForLegacyGateway() (test-only) deleted.
 *
 * If a second channel really arrives, Extract Superclass/Interface THEN - with real
 * requirements in hand. Version control remembers the deleted code.
 */
public class EmailSender {

    public String send(String to, String message) {
        return "EMAIL to " + to + ": " + message;
    }
}

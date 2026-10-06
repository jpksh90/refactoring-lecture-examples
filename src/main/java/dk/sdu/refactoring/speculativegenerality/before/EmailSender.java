package dk.sdu.refactoring.speculativegenerality.before;

import java.util.Map;

public class EmailSender extends AbstractNotificationSender {

    // SMELL: "options" and "priority" are never used - they exist "just in case"
    @Override
    public String send(String to, String message, Map<String, String> options, int priority) {
        return "EMAIL to " + to + ": " + message;
    }

    // SMELL: only ever called from tests - dead code in production
    public String formatForLegacyGateway(String to, String message) {
        return "LEGACY|" + to + "|" + message;
    }
}

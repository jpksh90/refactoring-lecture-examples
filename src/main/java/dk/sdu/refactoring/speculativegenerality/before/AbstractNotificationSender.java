package dk.sdu.refactoring.speculativegenerality.before;

import java.util.Map;

/**
 * SMELL: Speculative Generality (slide 42) - "we might need SMS, push, pigeons... one day".
 * An abstract class with exactly ONE subclass, ever.
 */
public abstract class AbstractNotificationSender {

    public abstract String send(String to, String message, Map<String, String> options, int priority);
}

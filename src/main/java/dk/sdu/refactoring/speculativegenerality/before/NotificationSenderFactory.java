package dk.sdu.refactoring.speculativegenerality.before;

/**
 * SMELL: Speculative Generality (delegation) - a factory that can only ever build one thing.
 */
public class NotificationSenderFactory {

    public AbstractNotificationSender create() {
        return new EmailSender();
    }
}

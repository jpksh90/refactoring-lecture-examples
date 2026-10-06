package dk.sdu.refactoring.speculativegenerality.after;

public class NotificationService {

    // REFACTORING: Inline Class / Inline Function - the one-product factory is gone; construct directly
    private final EmailSender sender = new EmailSender();

    public String welcome(String email) {
        return sender.send(email, "Welcome!");
    }
}

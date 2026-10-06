package dk.sdu.refactoring.speculativegenerality.before;

import java.util.Map;

public class NotificationService {

    private final AbstractNotificationSender sender = new NotificationSenderFactory().create();

    public String welcome(String email) {
        return sender.send(email, "Welcome!", Map.of(), 0);   // callers must pass dummy values
    }
}

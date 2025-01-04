package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail;

import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Content;

public class MailContent extends Content {
    public MailContent(String message, String subject) {
        super(message);
        this.subject = subject;
    }

    private String subject;

    public String getSubject() {
        return subject;
    }
}

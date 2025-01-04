package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail;

import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Notification;

public class MailNotification  extends Notification {
    public MailNotification(
            MailContent content, MailReceiverDetails receiverDetails, MailSenderDetails senderDetails) {
        super(content, receiverDetails, senderDetails);
    }
}

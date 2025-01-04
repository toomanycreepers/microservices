package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms;

import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Notification;

public class SmsNotification extends Notification {
    public SmsNotification(
            SmsContent content, SmsReceiverDetails receiverDetails, SmsSenderDetails senderDetails) {
        super(content, receiverDetails, senderDetails);
    }
}

package permyakov_skorokhodov.api_gateway.business_logic.services.mapping;

import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.API.DTOs.MailNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.API.DTOs.SmsNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailContent;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailNotification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailReceiverDetails;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailSenderDetails;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsContent;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsNotification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsReceiverDetails;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsSenderDetails;

@Service
public class NotificationMapper {
    public MailNotification mapMailNotificationFromDTO(MailNotificationTaskRequest dto){
        MailNotification model = new MailNotification(
                new MailContent(dto.getMessage(), dto.getSubject()),
                new MailReceiverDetails(dto.getReceiverAddress()),
                new MailSenderDetails(dto.getSenderAddress())
        );

        return model;
    }

    public SmsNotification mapSmsNotificationFromDTO(SmsNotificationTaskRequest dto){
        SmsNotification model = new SmsNotification(
                new SmsContent(dto.getMessage()),
                new SmsReceiverDetails(dto.getReceiverNumber()),
                new SmsSenderDetails(dto.getSenderNumber())
        );

        return model;
    }
}

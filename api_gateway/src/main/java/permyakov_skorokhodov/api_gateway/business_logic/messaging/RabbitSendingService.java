package permyakov_skorokhodov.api_gateway.business_logic.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl.RabbitMailDTO;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl.RabbitSmsDTO;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.senders.impl.RabbitMailSender;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.senders.impl.RabbitSmsSender;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Notification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailNotification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsNotification;
import permyakov_skorokhodov.api_gateway.business_logic.services.mapping.BrokerMessagesMapper;

@Service
public class RabbitSendingService {
    @Autowired
    private BrokerMessagesMapper messageMapper;

    @Autowired
    private RabbitMailSender mailSender;

    @Autowired
    private RabbitSmsSender smsSender;

    public void mapAndSend(Notification notification, String sendingType, String taskId)
            throws JsonProcessingException, Exception {
        switch(sendingType){
            case "mail":
                RabbitMailDTO mailDTO = messageMapper.mapMailMessage((MailNotification) notification, taskId);
                mailSender.send(mailDTO);
            case "sms":
                RabbitSmsDTO smsDTO = messageMapper.mapSmsMessage((SmsNotification) notification, taskId);
                smsSender.send(smsDTO);
            default:
                throw new Exception("Provided unknown sending type: " + sendingType);
        }
    }
}

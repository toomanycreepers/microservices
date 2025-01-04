package permyakov_skorokhodov.api_gateway.business_logic.services.mapping;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl.RabbitMailDTO;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl.RabbitSmsDTO;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailNotification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsNotification;

@Service
public class BrokerMessagesMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public RabbitMailDTO mapMailMessage(MailNotification model, String taskId){
        JsonNode notificationJson = objectMapper.valueToTree(model);

        RabbitMailDTO dto = new RabbitMailDTO(
                taskId,
                notificationJson.get("receiverDetails").get("address").asText(),
                notificationJson.get("senderDetails").get("address").asText(),
                notificationJson.get("content").get("subject").asText(),
                notificationJson.get("content").get("message").asText()
        );

        return dto;
    }

    public RabbitSmsDTO mapSmsMessage(SmsNotification model, String taskId){
        JsonNode notificationJson = objectMapper.valueToTree(model);

        RabbitSmsDTO dto = new RabbitSmsDTO(
                taskId,
                notificationJson.get("receiverDetails").get("receiverNumber").asText(),
                notificationJson.get("senderDetails").get("senderNumber").asText(),
                notificationJson.get("content").get("message").asText()
        );

        return dto;
    }
}

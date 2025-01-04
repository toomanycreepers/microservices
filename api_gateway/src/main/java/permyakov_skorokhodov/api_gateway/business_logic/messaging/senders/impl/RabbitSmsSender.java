package permyakov_skorokhodov.api_gateway.business_logic.messaging.senders.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.RabbitConfig;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.BrokerMessageDTO;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl.RabbitSmsDTO;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.senders.RabbitSender;
import permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask.NotificationTask;

@Service
public class RabbitSmsSender implements RabbitSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public void send(BrokerMessageDTO dto) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
                RabbitConfig.SMS_NOTIFICATIONS_QUEUE, mapper.writeValueAsString(dto));
    }
}

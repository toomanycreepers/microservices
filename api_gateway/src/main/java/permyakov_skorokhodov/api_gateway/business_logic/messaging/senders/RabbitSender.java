package permyakov_skorokhodov.api_gateway.business_logic.messaging.senders;

import com.fasterxml.jackson.core.JsonProcessingException;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.BrokerMessageDTO;

public interface RabbitSender {
    void send(BrokerMessageDTO dto) throws JsonProcessingException;
}

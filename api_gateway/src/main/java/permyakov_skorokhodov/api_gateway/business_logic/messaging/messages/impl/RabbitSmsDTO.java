package permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl;

import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.BrokerMessageDTO;

@Getter
public class RabbitSmsDTO extends BrokerMessageDTO {
    public RabbitSmsDTO(String taskId, String to, String from, String body) {
        super(taskId, to, from);
        this.body = body;
    }

    private String body;

    public String getBody() {
        return body;
    }
}

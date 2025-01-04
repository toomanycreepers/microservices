package permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.impl;

import permyakov_skorokhodov.api_gateway.business_logic.messaging.messages.BrokerMessageDTO;

public class RabbitMailDTO extends BrokerMessageDTO {
    public RabbitMailDTO(
            String taskId, String to, String from, String subject, String text) {
        super(taskId, to, from);
        this.subject = subject;
        this.text = text;
    }

    private String subject;

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    private  String text;
}

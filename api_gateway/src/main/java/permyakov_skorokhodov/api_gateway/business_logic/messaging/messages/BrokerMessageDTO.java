package permyakov_skorokhodov.api_gateway.business_logic.messaging.messages;

import lombok.Getter;

@Getter
public abstract class BrokerMessageDTO {
    protected BrokerMessageDTO(String taskId, String to, String from){
        this.taskId = taskId;
        this.to = to;
        this.from = from;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    protected String taskId;

    protected String to;

    protected String from;
}

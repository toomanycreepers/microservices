package permyakov_skorokhodov.api_gateway.API.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class MailNotificationTaskRequest implements NotificationTaskRequest{
    @JsonProperty("to")
    private String receiverAddress;

    @JsonProperty("from")
    private String senderAddress;

    public MailNotificationTaskRequest(String receiverAddress, String senderAddress, String subject, String message) {
        this.receiverAddress = receiverAddress;
        this.senderAddress = senderAddress;
        this.subject = subject;
        this.message = message;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public String getSubject() {
        return subject;
    }

    @JsonProperty("subject")
    private String subject;

    @JsonProperty("message")
    private String message;

    @Override
    public String getMessage(){
        return message;
    }
}

package permyakov_skorokhodov.api_gateway.API.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SmsNotificationTaskRequest implements NotificationTaskRequest{
    @JsonProperty("to")
    private String receiverNumber;

    public SmsNotificationTaskRequest(String receiverNumber, String senderNumber, String message) {
        this.receiverNumber = receiverNumber;
        this.senderNumber = senderNumber;
        this.message = message;
    }

    @JsonProperty("from")
    private String senderNumber;

    @JsonProperty("message")
    private String message;

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    @Override
    public String getMessage(){
        return message;
    }
}

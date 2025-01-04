package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.SenderDetails;

public class SmsSenderDetails extends SenderDetails {
    private String senderNumber;

    public SmsSenderDetails(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public String getSenderNumber() {
        return senderNumber;
    }
}

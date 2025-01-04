package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms;

import lombok.AllArgsConstructor;
import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.ReceiverDetails;

public class SmsReceiverDetails extends ReceiverDetails {
    public String getReceiverNumber() {
        return receiverNumber;
    }

    public SmsReceiverDetails(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    private String receiverNumber;
}

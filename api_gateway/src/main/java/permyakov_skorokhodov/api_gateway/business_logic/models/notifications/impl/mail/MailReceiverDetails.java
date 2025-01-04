package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.ReceiverDetails;

public class MailReceiverDetails extends ReceiverDetails {
    public MailReceiverDetails(String address) {
        this.address = address;
    }

    private String address;

    public String getAddress() {
        return address;
    }
}

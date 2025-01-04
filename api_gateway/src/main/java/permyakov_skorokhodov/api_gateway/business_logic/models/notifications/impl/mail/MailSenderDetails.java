package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail;

import lombok.AllArgsConstructor;
import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.SenderDetails;

public class MailSenderDetails extends SenderDetails {
    private String address;

    public MailSenderDetails(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}

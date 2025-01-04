package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms;

import lombok.Getter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Content;

public class SmsContent extends Content {
    public SmsContent(String message) {
        super(message);
    }
}

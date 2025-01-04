package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public abstract class Notification {
    protected Notification(
            Content content, ReceiverDetails receiverDetails, SenderDetails senderDetails){
        this.content = content;
        this.receiverDetails = receiverDetails;
        this.senderDetails = senderDetails;
    }

    protected Content content;

    public Content getContent() {
        return content;
    }

    public ReceiverDetails getReceiverDetails() {
        return receiverDetails;
    }

    public SenderDetails getSenderDetails() {
        return senderDetails;
    }

    protected ReceiverDetails receiverDetails;

    protected SenderDetails senderDetails;
}

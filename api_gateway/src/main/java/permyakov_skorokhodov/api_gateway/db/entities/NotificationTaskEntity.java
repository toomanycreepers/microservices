package permyakov_skorokhodov.api_gateway.db.entities;

import com.fasterxml.jackson.databind.JsonNode;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notification_tasks")
public class NotificationTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    public UUID getId() {
        return id;
    }

    public String getSendingType() {
        return sendingType;
    }

    public String getStatus() {
        return status;
    }

    public JsonNode getContent() {
        return content;
    }

    public JsonNode getReceiverDetails() {
        return receiverDetails;
    }

    @Nullable
    public JsonNode getSenderDetails() {
        return senderDetails;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Column(name = "sending_type")
    private String sendingType;

    @Column(name = "status")
    private String status;

    @Column(name = "content")
    private JsonNode content;

    @Column(name = "receiver_details")
    private JsonNode receiverDetails;

    @Column(name = "sender_details")
    @Nullable
    private JsonNode senderDetails;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public NotificationTaskEntity(
            String status,
            String sendingType,
            JsonNode content,
            JsonNode receiverDetails,
            JsonNode senderDetails,
            LocalDateTime createdAt){
        this.status = status;
        this.sendingType = sendingType;
        this.content = content;
        this.receiverDetails = receiverDetails;
        this.senderDetails = senderDetails;
        this.createdAt = createdAt;
    }

    public NotificationTaskEntity(){}
}

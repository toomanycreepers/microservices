package permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask;

import lombok.Setter;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Notification;

import java.time.LocalDateTime;
import java.util.UUID;

public class NotificationTask {
    public UUID getId() {
        return id;
    }

    public NotificationTaskStatus getStatus() {
        return status;
    }

    public Notification getNotification() {
        return notification;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    private UUID id;

    public NotificationTask(NotificationTaskStatus status, Notification notification, LocalDateTime createdAt) {
        this.status = status;
        this.notification = notification;
        this.createdAt = createdAt;
    }

    @Setter
    private NotificationTaskStatus status = NotificationTaskStatus.AWAITING_DISPATCH;

    private Notification notification;

    private LocalDateTime createdAt;
}

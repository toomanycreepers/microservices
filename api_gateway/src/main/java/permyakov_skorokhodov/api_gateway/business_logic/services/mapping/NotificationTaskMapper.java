package permyakov_skorokhodov.api_gateway.business_logic.services.mapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask.NotificationTask;
import permyakov_skorokhodov.api_gateway.db.entities.NotificationTaskEntity;

@Service
public class NotificationTaskMapper {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NotificationTaskEntity mapModelToEntity(NotificationTask model, String sendingType){
        NotificationTaskEntity entity = new NotificationTaskEntity(
                model.getStatus().name(),
                sendingType,
                objectMapper.valueToTree(model.getNotification().getContent()),
                objectMapper.valueToTree(model.getNotification().getReceiverDetails()),
                objectMapper.valueToTree(model.getNotification().getSenderDetails()),
                model.getCreatedAt()
        );

        return entity;
    }
}

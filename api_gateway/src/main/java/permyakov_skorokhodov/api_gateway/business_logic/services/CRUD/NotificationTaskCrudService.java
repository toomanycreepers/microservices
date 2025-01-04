package permyakov_skorokhodov.api_gateway.business_logic.services.CRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask.NotificationTask;
import permyakov_skorokhodov.api_gateway.business_logic.services.mapping.NotificationTaskMapper;
import permyakov_skorokhodov.api_gateway.db.entities.NotificationTaskEntity;
import permyakov_skorokhodov.api_gateway.db.repositories.NotificationTaskRepository;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class NotificationTaskCrudService {
    @Autowired
    private NotificationTaskRepository repository;

    @Autowired
    private NotificationTaskMapper taskMapper;

    public String create(NotificationTask task, String sendingType){
        NotificationTaskEntity entity = taskMapper.mapModelToEntity(task, sendingType);

        String savedEntityId =  repository.save(entity).getId().toString();

        return savedEntityId;
    }

    public String getStatusById(String stringId) throws NoSuchElementException{
        UUID id = UUID.fromString(stringId);

        NotificationTaskEntity taskEntity = repository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No such notification task with ${stringId} id"));

        String status = taskEntity.getStatus();

        return status;
    }
}

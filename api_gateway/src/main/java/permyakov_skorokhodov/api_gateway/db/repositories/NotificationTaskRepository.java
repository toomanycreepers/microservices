package permyakov_skorokhodov.api_gateway.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import permyakov_skorokhodov.api_gateway.db.entities.NotificationTaskEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTaskEntity, UUID> {

}

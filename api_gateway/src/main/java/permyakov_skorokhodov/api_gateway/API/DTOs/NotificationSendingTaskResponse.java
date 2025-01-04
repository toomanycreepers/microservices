package permyakov_skorokhodov.api_gateway.API.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class NotificationSendingTaskResponse {
    public String getTaskId() {
        return taskId;
    }

    public NotificationSendingTaskResponse(String taskId) {
        this.taskId = taskId;
    }

    @JsonProperty("task-id")
    private String taskId;
}

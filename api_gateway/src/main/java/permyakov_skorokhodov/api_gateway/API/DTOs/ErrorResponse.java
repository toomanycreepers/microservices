package permyakov_skorokhodov.api_gateway.API.DTOs;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public final class ErrorResponse {
    @JsonProperty("message")
    private String message;

    public String getMessage() {
        return message;
    }
}

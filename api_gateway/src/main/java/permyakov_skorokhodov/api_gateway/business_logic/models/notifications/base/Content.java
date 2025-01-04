package permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base;

public abstract class Content {
    protected Content(String message){
        this.message = message;
    }
    protected String message;

    public String getMessage() {
        return message;
    }
}

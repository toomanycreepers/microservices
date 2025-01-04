package permyakov_skorokhodov.api_gateway.API.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import permyakov_skorokhodov.api_gateway.API.DTOs.MailNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.API.DTOs.NotificationSendingTaskResponse;
import permyakov_skorokhodov.api_gateway.API.DTOs.SmsNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.business_logic.services.CRUD.NotificationTaskCrudService;
import permyakov_skorokhodov.api_gateway.business_logic.services.hub.ServicesHub;

@RestController
public class NotificationSendingController {
    @Autowired
    private ServicesHub serviceHub;

    @Autowired
    private NotificationTaskCrudService crudService;

    @PostMapping("/mail")
    public ResponseEntity<?> sendMailNotification(
            @RequestBody MailNotificationTaskRequest sendingRequest){
        try{
            String taskId = serviceHub.executeMailNotificationTask(sendingRequest);

            return new ResponseEntity<NotificationSendingTaskResponse>(
                    new NotificationSendingTaskResponse(taskId),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST) ;
        }
    }

    @PostMapping("/sms")
    public ResponseEntity<NotificationSendingTaskResponse> sendSmsNotification(
            @RequestBody SmsNotificationTaskRequest sendingRequest){
        try{
            String taskId = serviceHub.executeSmsNotificationTask(sendingRequest);

            return new ResponseEntity<NotificationSendingTaskResponse>(
                    new NotificationSendingTaskResponse(taskId),
                    HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        }
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<String> getNotificationTaskStatus(@PathVariable String id){
        try{
            String status = crudService.getStatusById(id);

            return new ResponseEntity<String>(status, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST) ;
        }
    }
}

package permyakov_skorokhodov.api_gateway.business_logic.services.hub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import permyakov_skorokhodov.api_gateway.API.DTOs.MailNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.API.DTOs.NotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.API.DTOs.SmsNotificationTaskRequest;
import permyakov_skorokhodov.api_gateway.business_logic.messaging.RabbitSendingService;
import permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask.NotificationTask;
import permyakov_skorokhodov.api_gateway.business_logic.models.notificationTask.NotificationTaskStatus;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.base.Notification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.mail.MailNotification;
import permyakov_skorokhodov.api_gateway.business_logic.models.notifications.impl.sms.SmsNotification;
import permyakov_skorokhodov.api_gateway.business_logic.services.CRUD.NotificationTaskCrudService;
import permyakov_skorokhodov.api_gateway.business_logic.services.mapping.NotificationMapper;

import java.time.LocalDateTime;

@Service
public class ServicesHub {
    @Autowired
    private RabbitSendingService rabbitSender;

    @Autowired
    private NotificationTaskCrudService tasksCrudService;

    @Autowired
    private NotificationMapper notificationMapper;

    private String executeNotificationTask(NotificationTaskRequest dto, String sendingType)
            throws Exception {
        Notification notification;

        String createdTaskId;

        switch (sendingType){
            case "mail":
                notification = notificationMapper.mapMailNotificationFromDTO((MailNotificationTaskRequest) dto);

                createdTaskId = tasksCrudService.create(
                        new NotificationTask(
                                NotificationTaskStatus.AWAITING_DISPATCH,
                                notification,
                                LocalDateTime.now()
                        ), sendingType);

                rabbitSender.mapAndSend(notification, sendingType, createdTaskId);

                return createdTaskId;

            case "sms":
                notification = notificationMapper.mapSmsNotificationFromDTO((SmsNotificationTaskRequest) dto);

                createdTaskId = tasksCrudService.create(
                        new NotificationTask(
                                NotificationTaskStatus.AWAITING_DISPATCH,
                                notification,
                                LocalDateTime.now()
                        ), sendingType);

                rabbitSender.mapAndSend(notification, sendingType, createdTaskId);

                return createdTaskId;

            default:
                throw new Exception("Provided unknown sending type: " + sendingType);
        }
    }

    public String executeMailNotificationTask(MailNotificationTaskRequest dto) throws Exception {
        return executeNotificationTask(dto, "mail");
    }

    public String executeSmsNotificationTask(SmsNotificationTaskRequest dto) throws Exception {
        return executeNotificationTask(dto, "sms");
    }
}

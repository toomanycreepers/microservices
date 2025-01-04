package permyakov_skorokhodov.mail_sender.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import permyakov_skorokhodov.mail_sender.services.MailService;

@Service
public class MailListener {

    @Autowired
    private MailService emailService;

    @RabbitListener(queues = "emailQueue")
    public void receiveMessage(String jsonString) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            EmailMessage emailMessage = objectMapper.readValue(jsonString, EmailMessage.class);
            emailService.sendEmail(emailMessage.getFrom(), emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
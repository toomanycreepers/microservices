package permyakov_skorokhodov.sms_sender.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import permyakov_skorokhodov.sms_sender.utils.SMSDTO;

@Service
public class SMSService {
    @Value("${TWILIO_ACCOUNT_SID}")
    private String accountSid;

    @Value("${TWILIO_AUTH_TOKEN}")
    private String authToken;

    public Message sendSMS(SMSDTO dto) {
        Twilio.init(accountSid, authToken);
        return Message.creator(
                new com.twilio.type.PhoneNumber(dto.to),
                new com.twilio.type.PhoneNumber(dto.from),
                dto.body)
           .create();
    }
}

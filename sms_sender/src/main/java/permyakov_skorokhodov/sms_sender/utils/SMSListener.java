package permyakov_skorokhodov.sms_sender.utils;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import permyakov_skorokhodov.sms_sender.service.SMSService;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SMSListener {
	
	@Autowired
	private SMSService smsService;

	@RabbitListener(queues = "smsQueue")
	public Message sendSMS(SMSDTO dto) {
		return smsService.sendSMS(dto);
	}
}

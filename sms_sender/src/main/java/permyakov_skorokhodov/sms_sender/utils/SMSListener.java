package permyakov_skorokhodov.sms_sender.utils;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import permyakov_skorokhodov.sms_sender.service.SMSService;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SMSListener {

	@Autowired
	private SMSService smsService;

	@RabbitListener(queues = "smsQueue")
	public void sendSMS(String jsonString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			SMSDTO smsdto = objectMapper.readValue(jsonString, SMSDTO.class);
			smsService.sendSMS(smsdto);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
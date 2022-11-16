package microservice.queue.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.queue.authentication.dto.UserRegisterDTO;

@Service
public class Sender {

	@Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(UserRegisterDTO userRegisterDTO) {
        System.out.println("[BUSSERVICE] SEND String MSG=["+userRegisterDTO+"]");
        jmsTemplate.convertAndSend("RESULT_BUS_MNG",userRegisterDTO);
    }

}

package microservice.authentication.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import microservice.common.UserRegisterDTO;

@Service
public class AuthenticationQueueService{
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean sendMessage(UserRegisterDTO userRegisterDTO){
        jmsTemplate.convertAndSend("TEST_2", userRegisterDTO);
        return true;
    }
    
    @JmsListener(destination = "TEST_2", containerFactory = "connectionFactory")
    public void receiveMessage(UserRegisterDTO userRegister) {
      System.out.println("Received <" + userRegister.toString() + ">");
    }
}

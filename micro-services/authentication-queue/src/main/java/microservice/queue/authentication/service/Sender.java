package microservice.queue.authentication.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.queue.authentication.dto.UserRegisterDTO;

@Service
public class Sender {

    private  JmsTemplate jmsTemplate;

    private static final String QUEUE_KEY = "authentication-queue-sender";

    private String queue;

    private  Environment environment;

    @PostConstruct
    public void init() {
        queue = environment.getProperty(QUEUE_KEY);
    }

    public void sendMessage(UserRegisterDTO user) {

        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an personne message."+user);
        jmsTemplate.convertAndSend(queue, user);
    }
}

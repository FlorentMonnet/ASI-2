package microservice.queue.authentication.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.queue.authentication.dto.UserRegisterDTO;


@Service
public class Receiver {

    private Sender sender;

    @JmsListener(destination = "${authentication-queue-receiver}")
    public void receiveMessage(UserRegisterDTO user) {
        UserRegisterDTO newPersonne = new UserRegisterDTO(user.getIsAdmin(), user.getMoney(), user.getSurname(), user.getName(), user.getPassword(), user.getMail());
        sender.sendMessage(newPersonne);
    }
}

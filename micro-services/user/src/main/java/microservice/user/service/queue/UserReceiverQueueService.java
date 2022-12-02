package microservice.user.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.common.TransactionUserDTO;
import microservice.user.entity.User;
import microservice.user.service.UserService;
@Service
public class UserReceiverQueueService {
	
	@Autowired
	UserService userService;
	
	@JmsListener(destination = "createUser", containerFactory = "connectionFactory")
	public void receiveCreationUser(User user) {
	  System.out.println("<Received in creation queue <" + user.toString() + ">");
	  userService.addUser(user);
	}

	@JmsListener(destination = "updateUser", containerFactory = "connectionFactory")
	public void receiveUpdateUser(User user) {
	  System.out.println("<Received in update queue <" + user.toString() + ">");
	  userService.updateUser(user);
	}
	
	@JmsListener(destination = "updateUserToPay", containerFactory = "connectionFactory")
	public void receiveCardToPay(TransactionUserDTO transactionUserDTO) {
	  System.out.println("<Received in pay queue <" + transactionUserDTO.toString() + ">");
	  userService.updateUserToPay(transactionUserDTO);
	}

}

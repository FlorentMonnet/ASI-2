package microservice.user.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.user.dto.UserRegisterDTO;
import microservice.user.entity.User;
import microservice.user.rest.transaction.TransactionUserDTO;
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
	
	@JmsListener(destination = "registerUser", containerFactory = "connectionFactory")
	public void receiveCreationUser(UserRegisterDTO userRegisterDTO) {
	  System.out.println("<Received in register queue <" + userRegisterDTO.toString() + ">");
	  userService.register(userRegisterDTO);
	}

	@JmsListener(destination = "updateUser", containerFactory = "connectionFactory")
	public void receiveUpdateUser(User user) {
	  System.out.println("<Received in update queue <" + user.toString() + ">");
	  userService.updateUser(user);
	}
	
	@JmsListener(destination = "updateUserToBuy", containerFactory = "connectionFactory")
	public void receiveUserToBuy(TransactionUserDTO transactionUserDTO) {
	  System.out.println("<Received in pay queue <" + transactionUserDTO.toString() + ">");
	  userService.updateUserToPay(transactionUserDTO);
	}
	
	@JmsListener(destination = "updateUserToSell", containerFactory = "connectionFactory")
	public void receiveUserToSell(TransactionUserDTO transactionUserDTO) {
	  System.out.println("<Received in sell queue <" + transactionUserDTO.toString() + ">");
	  userService.updateUserToSell(transactionUserDTO);
	}

}

package microservice.user.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.user.entity.User;
import microservice.user.rest.transaction.TransactionUserDTO;

@Service
public class UserSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addUserToCreationQueue(User user){
        jmsTemplate.convertAndSend("createUser", user);
        return true;
    }
    
    public boolean addUserToUpdateQueue(User user){
        jmsTemplate.convertAndSend("updateUser", user);
        return true;
    }
    
    public boolean addTransactionUserToPayQueue(TransactionUserDTO transactionUserDTO){
        jmsTemplate.convertAndSend("updateUserToPay", transactionUserDTO);
        return true;
    }
}



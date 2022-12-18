package microservice.user.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;


import microservice.common.TransactionUserDTO;

import microservice.common.UserRegisterDTO;

import microservice.user.entity.User;

@Service
public class UserSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addUserToCreationQueue(User user){
        jmsTemplate.convertAndSend("createUser", user);
        return true;
    }
    
    public boolean addUserToRegisterQueue(UserRegisterDTO userRegisterDTO){
        jmsTemplate.convertAndSend("registerUser", userRegisterDTO);
        return true;
    }
    
    public boolean addUserToUpdateQueue(User user){
        jmsTemplate.convertAndSend("updateUser", user);
        return true;
    }
    
    public boolean addTransactionUserToPayQueue(TransactionUserDTO transactionUserDTO){
        jmsTemplate.convertAndSend("updateUserToBuy", transactionUserDTO);
        return true;
    }
    
    public boolean addTransactionUserToSellQueue(TransactionUserDTO transactionUserDTO){
        jmsTemplate.convertAndSend("updateUserToSell", transactionUserDTO);
        return true;
    }
}



package microservice.transaction.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.transaction.entity.Transaction;

@Service
public class TransactionSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addTransactionToCreationQueue(Transaction transaction){
        jmsTemplate.convertAndSend("createTransaction", transaction);
        return true;
    }
    
    public boolean addTransactionToUpdateQueue(Transaction transaction){
        jmsTemplate.convertAndSend("updateTransaction", transaction);
        return true;
    }
}



package microservice.transaction.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.transaction.entity.Transaction;

@Service
public class TransactionSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addTransactionToBuyQueue(Transaction transaction){
        jmsTemplate.convertAndSend("buy", transaction);
        return true;
    }
    
    public boolean addTransactionToUpdateQueue(Transaction transaction){
        jmsTemplate.convertAndSend("updateTransaction", transaction);
        return true;
    }
    
    public boolean addIdTransactionToIsCardOkQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsCardOk", idTransaction);
        return true;
    }
    
    public boolean addIdTransactionToIsUserOkQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsUserOk", idTransaction);
        return true;
    }
    
}



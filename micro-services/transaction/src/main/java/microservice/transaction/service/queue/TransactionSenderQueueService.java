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
    
    public boolean addTransactionToSellQueue(Transaction transaction){
        jmsTemplate.convertAndSend("sell", transaction);
        return true;
    }
    
    public boolean addTransactionToUpdateQueue(Transaction transaction){
        jmsTemplate.convertAndSend("updateTransaction", transaction);
        return true;
    }
    
    public boolean addIdTransactionToIsCardOkToBuyQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsCardOkToBuy", idTransaction);
        return true;
    }
    
    public boolean addIdTransactionToIsUserOkToBuyQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsUserOkToBuy", idTransaction);
        return true;
    }
    
    public boolean addIdTransactionToIsCardOkToSellQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsCardOkToSell", idTransaction);
        return true;
    }
    
    public boolean addIdTransactionToIsUserOkToSellQueue(Integer idTransaction){
        jmsTemplate.convertAndSend("updateIsUserOkToSell", idTransaction);
        return true;
    }
    
}



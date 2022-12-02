package microservice.card.service.queue;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.entity.CardReference;
import microservice.card.rest.transaction.TransactionCardDTO;


@Service
public class CardSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addCardToCreationQueue(Card card){
        jmsTemplate.convertAndSend("createCard", card);
        return true;
    }
    
    public boolean addIdUserToInitUserCardsQueue(Integer id_user){
        jmsTemplate.convertAndSend("initUserCards", id_user);
        return true;
    }
    
    public boolean addCardToUpdateQueue(Card card){
        jmsTemplate.convertAndSend("updateCard", card);
        return true;
    }
    
    public boolean addTransactionCardToBuyQueue(TransactionCardDTO transactionCardDTO){
        jmsTemplate.convertAndSend("updateCardToBuy", transactionCardDTO);
        return true;
    }
    
    public boolean addTransactionCardToSellQueue(TransactionCardDTO transactionCardDTO){
        jmsTemplate.convertAndSend("updateCardToSell", transactionCardDTO);
        return true;
    }
    
    public boolean addInitUserCardsToCreationQueue(Integer id_user){
        jmsTemplate.convertAndSend("addInitUserCards", id_user);
        return true;
    }
}



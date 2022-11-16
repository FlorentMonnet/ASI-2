package microservice.card.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;

@Service
public class CardSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addCardToCreationQueue(Card card){
        jmsTemplate.convertAndSend("createCard", card);
        return true;
    }
    
    public boolean addCardToUpdateQueue(Card card){
        jmsTemplate.convertAndSend("updateCard", card);
        return true;
    }
}



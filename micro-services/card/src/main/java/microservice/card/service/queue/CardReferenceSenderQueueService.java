package microservice.card.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import microservice.card.entity.CardReference;

@Service
public class CardReferenceSenderQueueService {
	@Autowired
    JmsTemplate jmsTemplate;
	
    public boolean addCardReferenceToCreationQueue(CardReference cardReference){
        jmsTemplate.convertAndSend("createCardReference", cardReference);
        return true;
    }
    
    public boolean addCardReferenceToUpdateQueue(CardReference cardReference){
        jmsTemplate.convertAndSend("updateCardReference", cardReference);
        return true;
    }
    
}



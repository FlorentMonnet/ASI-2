package microservice.card.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.card.entity.CardReference;
import microservice.card.service.CardReferenceService;

@Service
public class CardReferenceReceiverQueueService {
	@Autowired
	CardReferenceService cardReferenceService;
	
	@JmsListener(destination = "createCardReference", containerFactory = "connectionFactory")
	public void receiveCreationCardReference(CardReference cardReference) {
	  System.out.println("<Received in creation queue <" + cardReference.toString() + ">");
	  cardReferenceService.addCardReference(cardReference);
	}

	@JmsListener(destination = "updateCardReference", containerFactory = "connectionFactory")
	public void receiveUpdateCardReference(CardReference cardReference) {
	  System.out.println("<Received in update queue <" + cardReference.toString() + ">");
	  cardReferenceService.updateCardReference(cardReference);
	}
}

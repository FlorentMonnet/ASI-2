package microservice.card.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.service.CardService;
@Service
public class CardReceiverQueueService {
	
	@Autowired
	CardService cardService;
	
	@JmsListener(destination = "createCard", containerFactory = "connectionFactory")
	public void receiveCreationCard(Card card) {
	  System.out.println("<Received in creation queue <" + card.toString() + ">");
	  cardService.addCard(card);
	}

	@JmsListener(destination = "updateCard", containerFactory = "connectionFactory")
	public void receiveUpdateCard(Card card) {
	  System.out.println("<Received in update queue <" + card.toString() + ">");
	  cardService.updateCard(card);
	}

}

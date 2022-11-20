package microservice.card.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;

import microservice.card.service.CardService;
import microservice.common.TransactionCardDTO;
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
	
	@JmsListener(destination = "updateCardToPay", containerFactory = "connectionFactory")
	public void receiveCardToPay(TransactionCardDTO transactionCardDTO) {
	  System.out.println("<Received in pay queue <" + transactionCardDTO.toString() + ">");
	  cardService.updateCardToPay(transactionCardDTO);
	}
}

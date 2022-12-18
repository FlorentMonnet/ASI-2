package microservice.card.service.queue;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.entity.CardReference;
import microservice.card.rest.transaction.TransactionCardDTO;
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
	
	@JmsListener(destination = "initUserCards", containerFactory = "connectionFactory")
	public void receiveCreationCard(Integer id_user) {
	  System.out.println("<Received in init user cards queue <" + id_user.toString() + ">");
	  cardService.initUserCards(id_user);
	}

	@JmsListener(destination = "updateCard", containerFactory = "connectionFactory")
	public void receiveUpdateCard(Card card) {
	  System.out.println("<Received in update queue <" + card.toString() + ">");
	  cardService.updateCard(card);
	}
	
	@JmsListener(destination = "updateCardToBuy", containerFactory = "connectionFactory")
	public void receiveCardToBuy(TransactionCardDTO transactionCardDTO) {
	  System.out.println("<Received in buy queue <" + transactionCardDTO.toString() + ">");
	  cardService.updateCardToPay(transactionCardDTO);
	}
	
	@JmsListener(destination = "updateCardToSell", containerFactory = "connectionFactory")
	public void receiveCardToSell(TransactionCardDTO transactionCardDTO) {
	  System.out.println("<Received in sell queue <" + transactionCardDTO.toString() + ">");
	  cardService.updateCardToSell(transactionCardDTO);
	}
	
	@JmsListener(destination = "initUserCards", containerFactory = "connectionFactory")
	public void receiveCardToSell(Integer id_user) {
	  System.out.println("<Received in initUserCards queue <" + id_user.toString() + ">");
	  cardService.initUserCards(id_user);
	}
}

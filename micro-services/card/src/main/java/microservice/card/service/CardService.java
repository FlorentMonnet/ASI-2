package microservice.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.mapper.CardMapper;
import microservice.card.repository.CardRepository;

import microservice.card.service.queue.CardSenderQueueService;
import microservice.common.TransactionCardDTO;
import microservice.common.TransactionCardRestClient;

@Service
public class CardService {
	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	CardSenderQueueService cardSenderQueueService;
	
	@Autowired
	CardMapper cardMapper;
	
	@Autowired
	TransactionCardRestClient transactionCardRestClient;
	
	public List<Card> getCards() {
		List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}
	
	public String addCardToCreationQueue(Card card) {
		boolean result = cardSenderQueueService.addCardToCreationQueue(card);
		return result ? "Creation de la carte en cours" : "";
	}
	
	public String addCardToUpdateQueue(Card card) {
		boolean result = cardSenderQueueService.addCardToUpdateQueue(card);
		return result ? "Mise à jour de la carte en cours" : "";
	}
	
	public String addTransactionCardToPayQueue(TransactionCardDTO transactionCardDTO) {
		boolean result = cardSenderQueueService.addTransactionCardToPayQueue(transactionCardDTO);
		return result ? "Mise à jour de la carte en cours" : "";
	}
	
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Card updateCard(Card card) {
		return cardRepository.save(card);
	}
	
	public void updateCardToPay(TransactionCardDTO transactionCardDTO) {
		cardRepository.save(cardMapper.toModel(transactionCardDTO.getCard()));
		transactionCardRestClient.updateCardToPay(transactionCardDTO);
	}
	
	public Optional<Card> getCardById(Integer id) {
		System.out.println("GET CARD BY ID"+id);
		return cardRepository.findById(id);
	}
	
	public void deleteCardModel(Integer id) {
		cardRepository.deleteById(id);
	}
	
	public List<Card> getAllCardToSell(){
		return cardRepository.findByUser(null);
	}
}

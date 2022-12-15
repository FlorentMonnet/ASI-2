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
	
	public String addTransactionCardToBuyQueue(TransactionCardDTO transactionCardDTO) {
		boolean result = cardSenderQueueService.addTransactionCardToBuyQueue(transactionCardDTO);
		return result ? "Mise à jour de la carte en cours" : "";
	}
	
	public String addTransactionCardToSellQueue(TransactionCardDTO transactionCardDTO) {
		boolean result = cardSenderQueueService.addTransactionCardToSellQueue(transactionCardDTO);
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
		transactionCardRestClient.updateCardToBuy(transactionCardDTO);
	}
	
	public void updateCardToSell(TransactionCardDTO transactionCardDTO) {
		cardRepository.save(cardMapper.toModel(transactionCardDTO.getCard()));
		transactionCardRestClient.updateCardToSell(transactionCardDTO);
	}
	
	public Optional<Card> getCardById(Integer id) {
		return cardRepository.findById(id);
	}
	
	public void deleteCardModel(Integer id) {
		cardRepository.deleteById(id);
	}
	
	public List<Card> getAllCardToBuy(){
		return cardRepository.findByUser(null);
	}
	
	public List<Card> getAllCardToSell(Integer id_user){
		return cardRepository.findByUser(id_user);
	}
}

package microservice.card.service;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.card.dto.CardReferenceDTO;
import microservice.card.entity.Card;
import microservice.card.entity.CardReference;
import microservice.card.mapper.CardMapper;
import microservice.card.mapper.CardReferenceMapper;
import microservice.card.repository.CardRepository;

import microservice.card.service.queue.CardSenderQueueService;
import microservice.common.TransactionCardDTO;
import microservice.common.TransactionCardRestClient;

@Service
public class CardService {
	@Autowired
	CardRepository cardRepository;

	@Autowired
	CardReferenceService cardReferenceService;
	
	@Autowired
	CardSenderQueueService cardSenderQueueService;
	
	@Autowired
	CardMapper cardMapper;
	
	@Autowired
	CardReferenceMapper cardReferenceMapper;
	
	@Autowired
	TransactionCardRestClient transactionCardRestClient;
	private Random rand = new Random();
	
	public List<Card> getCards() {
		List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}
	
	public String addCardToCreationQueue(Card card) {
		boolean result = cardSenderQueueService.addCardToCreationQueue(card);
		return result ? "Creation de la carte en cours" : "";
	}
	
	public String addIdUserToInitUserCardsQueue(Integer id_user) {
		boolean result = cardSenderQueueService.addIdUserToInitUserCardsQueue(id_user);
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
	public Card getRandomCardFromReference(Integer id_user, CardReference cardReference)
	{
		Card cardToAdd = new Card();
		cardToAdd.setAttack(rand.nextFloat()*100);
		cardToAdd.setDefense(rand.nextFloat()*100);
		cardToAdd.setEnergy(100);
		cardToAdd.setHp(rand.nextFloat()*100);
		cardToAdd.setPrice(cardToAdd.computePrice());
		cardToAdd.setId_user(id_user);
		cardToAdd.setCardReference(cardReference);
		return cardToAdd;
	}
	
	public void initUserCards(Integer id_user) {
		List<CardReference> randomCardReferences = cardReferenceService.getRandomCardReferences();
		for(CardReference randomCardReference : randomCardReferences)
		{
			Card randomCard = getRandomCardFromReference(id_user,randomCardReference);
			addCardToCreationQueue(randomCard);
		}
	}
}

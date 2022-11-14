package microservice.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cardRepository;
	public List<Card> getCards() {
		List<Card> cards = new ArrayList<>();
		cardRepository.findAll().forEach(cards::add);
		return cards;
	}
	
	public Card addCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Card updateCard(Card card) {
		return cardRepository.save(card);
	}
	
	public Optional<Card> getCardById(Integer id) {
		return cardRepository.findById(id);
	}
	
	public void deleteCardModel(Integer id) {
		cardRepository.deleteById(id);
	}
	
	public List<Card> getAllCardToSell(){
		return cardRepository.findByUser(null);
	}





}

package microservice.card.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.card.entity.Card;
import microservice.card.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository cardRepository;

	public Card getCardById(Integer idCard) {
		return cardRepository.findById(idCard).orElseThrow(() -> new RuntimeException());
	}
}

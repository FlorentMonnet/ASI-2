package microservice.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.card.entity.CardReference;
import microservice.card.repository.CardReferenceRepository;
import microservice.card.service.queue.CardReferenceSenderQueueService;

@Service
public class CardReferenceService {
	@Autowired
	CardReferenceRepository cardReferenceRepository;
	@Autowired
	CardReferenceSenderQueueService cardReferenceSenderQueueService;
	
	public List<CardReference> getCardReferences() {
		List<CardReference> cardReferences = new ArrayList<>();
		cardReferenceRepository.findAll().forEach(cardReferences::add);
		return cardReferences;
	}
	
	public String addCardReferenceToCreationQueue(CardReference cardReference) {
		boolean result = cardReferenceSenderQueueService.addCardReferenceToCreationQueue(cardReference);
		return result ? "Creation de la référence de la carte en cours" : "";
	}
	
	public String addCardReferenceToUpdateQueue(CardReference cardReference) {

		boolean result = cardReferenceSenderQueueService.addCardReferenceToUpdateQueue(cardReference);
		return result ? "Mise à jour de la référence de la carte en cours" : "";
	}
	
	public CardReference addCardReference(CardReference cardReference) {
		return cardReferenceRepository.save(cardReference);
	}
	
	public CardReference updateCardReference(CardReference cardReference) {
		return cardReferenceRepository.save(cardReference);
	}
	
	public Optional<CardReference> getCardReferenceById(Integer id) {
		System.out.println("GET CARD REFERNECE BY ID"+id);
		return cardReferenceRepository.findById(id);
	}
	
	public void deleteCardReference(Integer id) {
		cardReferenceRepository.deleteById(id);
	}
}

package microservice.card.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
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
	
	public List<CardReference> getRandomCardReferences() {
		List<CardReference> cardRefList = getCardReferences();
		List<CardReference> cardsRefToReturn = new ArrayList<>();
		if( cardRefList.size()>0) {
			while (cardsRefToReturn.size() < 4) {
				Random rand=new Random();
				int rindex=rand.nextInt(cardRefList.size()-1);
				cardsRefToReturn.add(cardRefList.get(rindex));
//				return cardRefList.get(rindex);
			}
		}
		return cardsRefToReturn;
	}
	
	/**
	 * Executed after application start
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void doInitAfterStartup() {
		for(int i=0;i<5;i++){
			CardReference cardRef =new CardReference("name"+i,"description"+i,"family"+i,"affinity"+i,"http://medias.3dvf.com/news/sitegrab/gits2045.jpg","https://cdn.animenewsnetwork.com/thumbnails/fit600x1000/cms/feature/89858/05.jpg");
			addCardReferenceToCreationQueue(cardRef);
		}
	}

}

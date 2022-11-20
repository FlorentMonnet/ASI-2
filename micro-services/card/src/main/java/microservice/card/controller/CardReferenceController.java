package microservice.card.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import microservice.card.dto.CardReferenceDTO;
import microservice.card.entity.CardReference;
import microservice.card.mapper.CardReferenceMapper;
import microservice.card.service.CardReferenceService;

@RestController
@RequestMapping("/api/card-microservice")
public class CardReferenceController {
	@Autowired
	CardReferenceService cardReferenceService;
	
	@Autowired
	CardReferenceMapper cardReferenceMapper;
	
	@GetMapping("/card-reference/{id_card_reference}")
	private CardReferenceDTO getCardReference(@PathVariable Integer id_card_reference) {
		Optional<CardReference> cardReference = cardReferenceService.getCardReferenceById(id_card_reference);
		if(cardReference.isPresent()) {
			return cardReferenceMapper.toDTO(cardReference.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card Reference id:"+id_card_reference+", not found",null);
	}

	
	@GetMapping("/card-references")
	public List<CardReferenceDTO> getAllCardReferences() {
			return cardReferenceMapper.toDTOList(cardReferenceService.getCardReferences());
	}
	
	@PostMapping("/card-reference")
	public String addCardReference(@RequestBody CardReferenceDTO cardReference) {
		return cardReferenceService.addCardReferenceToCreationQueue(cardReferenceMapper.toModel(cardReference));
	}
	
	@PatchMapping("/card-reference/{id}")
	public String updateCardReference(@RequestBody CardReferenceDTO cardReference,@PathVariable Integer id) {
		cardReference.setId(id);
		return cardReferenceService.addCardReferenceToUpdateQueue(cardReferenceMapper.toModel(cardReference));
	}
	
	@DeleteMapping("/card-reference/{id}")
	public void deleteCardReference(@PathVariable Integer id) {
		cardReferenceService.deleteCardReference(id);
	}
}

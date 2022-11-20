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


import microservice.card.entity.Card;
import microservice.card.mapper.CardMapper;

import microservice.card.service.CardService;
import microservice.common.CardDTO;
import microservice.common.TransactionCardDTO;
@RestController
@RequestMapping("/api/card-microservice")
public class CardController {
		
	@Autowired
	CardService cardService;
	
	@Autowired
	CardMapper cardMapper;
	
	@GetMapping("/card/{id_card}")
	private CardDTO getCard(@PathVariable Integer id_card) {
		Optional<Card> card = cardService.getCardById(id_card);
		if(card.isPresent()) {
			return cardMapper.toDTO(card.get());
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card id:"+id_card+", not found",null);
	}

	
	@GetMapping("/cards")
	public List<CardDTO> getAllCards() {
			return cardMapper.toDTOList(cardService.getCards());
	}
	
	@PostMapping("/card")
	public String addCard(@RequestBody CardDTO card) {
		return cardService.addCardToCreationQueue(cardMapper.toModel(card));
	}
	
	@PatchMapping("/card/{id}")
	public String updateCard(@RequestBody CardDTO card,@PathVariable Integer id) {
		card.setId(id);
		return cardService.addCardToUpdateQueue(cardMapper.toModel(card));
	}
	
	@DeleteMapping("/card/{id}")
	public void deleteCard(@PathVariable Integer id) {
		cardService.deleteCardModel(id);
	}
	
	@GetMapping("/cardsToSell")
	private List<CardDTO> getCardsToSell() {
		return cardMapper.toDTOList(cardService.getAllCardToSell());
	}
	
	@PatchMapping("/pay-card/{id}")
	public void updateCardToPay(@RequestBody TransactionCardDTO transactionCardDTO,@PathVariable Integer id) {
		cardService.addTransactionCardToPayQueue(transactionCardDTO);
	}
}

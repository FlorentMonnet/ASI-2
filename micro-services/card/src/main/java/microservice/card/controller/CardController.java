package microservice.card.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.card.dto.CardDTO;
import microservice.card.mapper.CardMapper;
import microservice.card.service.CardService;

@RestController
@RequestMapping("/api/card-microservice")
public class CardController {
		
	@Autowired
	CardService cardService;
	
	@Autowired
	CardMapper cardMapper;
	
	@GetMapping("/card/{id_card}")
	public CardDTO getCardById(@PathVariable Integer id_card) {
		return cardMapper.toDTO(cardService.getCardById(id_card));
	}
}

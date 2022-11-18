package microservice.card.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import microservice.card.dto.CardDTO;
import microservice.card.entity.Card;
import microservice.card.service.CardReferenceService;

@Component
public class CardMapper {
		@Autowired
		CardReferenceService cardReferenceService;
		
		public Card toModel(CardDTO cardDTO) {
			Card card = new Card();
			
			card.setId_card(cardDTO.getId());
			card.setEnergy(cardDTO.getEnergy());
			card.setHp(cardDTO.getHp());
			card.setDefense(cardDTO.getDefense());
			card.setAttack(cardDTO.getAttack());
			card.setPrice(cardDTO.getPrice());
			card.setId_user(cardDTO.getId_user());
			card.setCardReference(cardReferenceService.getCardReferenceById(cardDTO.getId_card_reference()).get());
			return card;
		}
		
		public CardDTO toDTO(Card card) {
			CardDTO cardDTO = new CardDTO();
			
			cardDTO.setId(card.getId_card());
			cardDTO.setEnergy(card.getEnergy());
			cardDTO.setHp(card.getHp());
			cardDTO.setDefense(card.getDefense());
			cardDTO.setAttack(card.getAttack());
			cardDTO.setPrice(card.getPrice());
			cardDTO.setId_user(card.getId_user());
			cardDTO.setId_card_reference(card.getCardReference().getId());
			return cardDTO;
			
		}
		
		public List<CardDTO> toDTOList(List<Card> cards) {
			List<CardDTO> cardsDTO=new ArrayList<>();
			for(Card card: cards){
				cardsDTO.add(this.toDTO(card));
			}
			return cardsDTO;
		}
		
		public List<Card> toModelList(List<CardDTO> cardsDTO) {
			List<Card> cards=new ArrayList<>();
			for(CardDTO card: cardsDTO){
				cards.add(this.toModel(card));
			}
			return cards;
		}
}

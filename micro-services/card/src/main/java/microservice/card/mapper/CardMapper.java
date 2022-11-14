package microservice.card.mapper;

import org.springframework.stereotype.Component;

import microservice.card.dto.CardDTO;
import microservice.card.entity.Card;

@Component
public class CardMapper {
		
		public Card toModel(CardDTO cardDTO) {
			Card toReturn = new Card();
			
			toReturn.setId_card(cardDTO.getId());
			toReturn.setEnergy(cardDTO.getEnergy());
			toReturn.setHp(cardDTO.getHp());
			toReturn.setDefense(cardDTO.getDefense());
			toReturn.setAttack(cardDTO.getAttack());
			toReturn.setPrice(cardDTO.getPrice());
			toReturn.setId_user(cardDTO.getId_user());
			
			return toReturn;
			
		}
		
		public CardDTO toDTO(Card card) {
			CardDTO toReturn = new CardDTO();
			
			toReturn.setId(card.getId_card());
			toReturn.setEnergy(card.getEnergy());
			toReturn.setHp(card.getHp());
			toReturn.setDefense(card.getDefense());
			toReturn.setAttack(card.getAttack());
			toReturn.setPrice(card.getPrice());
			toReturn.setId_user(card.getId_user());
			
			return toReturn;
			
		}
}

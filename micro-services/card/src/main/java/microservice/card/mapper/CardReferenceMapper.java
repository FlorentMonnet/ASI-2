package microservice.card.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import microservice.card.entity.CardReference;
import microservice.common.CardReferenceDTO;


@Component
public class CardReferenceMapper {
	
	public CardReference toModel(CardReferenceDTO cardReferenceDTO) {
		CardReference cardReference = new CardReference();
		
		cardReference.setId(cardReferenceDTO.getId());
		cardReference.setAffinity(cardReferenceDTO.getAffinity());
		cardReference.setDescription(cardReferenceDTO.getDescription());
		cardReference.setFamily(cardReferenceDTO.getFamily());
		cardReference.setImgUrl(cardReferenceDTO.getImgUrl());
		cardReference.setSmallImgUrl(cardReferenceDTO.getSmallImgUrl());
		cardReference.setName(cardReferenceDTO.getName());
		
		return cardReference;
		
	}
	
	public CardReferenceDTO toDTO(CardReference cardReference) {
		CardReferenceDTO cardReferenceDTO = new CardReferenceDTO();
		
		cardReferenceDTO.setId(cardReference.getId());
		cardReferenceDTO.setAffinity(cardReference.getAffinity());
		cardReferenceDTO.setDescription(cardReference.getDescription());
		cardReferenceDTO.setFamily(cardReference.getFamily());
		cardReferenceDTO.setImgUrl(cardReference.getImgUrl());
		cardReferenceDTO.setSmallImgUrl(cardReference.getSmallImgUrl());
		cardReferenceDTO.setName(cardReference.getName());
		
		return cardReferenceDTO;
	}
	
	public List<CardReferenceDTO> toDTOList(List<CardReference> cardReferences) {
		List<CardReferenceDTO> cardReferencesDTO = new ArrayList<>();
		for(CardReference cardReference: cardReferences){
			cardReferencesDTO.add(this.toDTO(cardReference));
		}
		return cardReferencesDTO;
	}
	
	public List<CardReference> toModelList(List<CardReferenceDTO> cardReferencesDTO) {
		List<CardReference> cardReferences=new ArrayList<>();
		for(CardReferenceDTO cardReferenceDTO : cardReferencesDTO){
			cardReferences.add(this.toModel(cardReferenceDTO));
		}
		return cardReferences;
	}
}

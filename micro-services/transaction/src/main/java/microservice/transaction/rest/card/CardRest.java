package microservice.transaction.rest.card;

import java.util.List;
import java.util.Optional;

import microservice.transaction.dto.TransactionCardDTO;

public interface CardRest {
	public List<CardDTO> getAllCards();
	public Optional<CardDTO> getCardbById(Integer id_card);
	public List<CardDTO> getCardsbByIdFamily(Integer id_family);
	public void createCard(CardDTO dto);
	public void updateCardToPay(TransactionCardDTO dto);
}

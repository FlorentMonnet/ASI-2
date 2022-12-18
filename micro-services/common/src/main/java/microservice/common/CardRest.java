package microservice.common;

import java.util.List;
import java.util.Optional;


public interface CardRest {
	public List<CardDTO> getAllCards();
	public Optional<CardDTO> getCardbById(Integer id_card);
	public List<CardDTO> getCardsbByIdFamily(Integer id_family);
	public void createCard(CardDTO dto);
	public void updateCardToBuy(TransactionCardDTO dto);
	public void updateCardToSell(TransactionCardDTO dto);
	
}

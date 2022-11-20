package microservice.card.rest.transaction;
import microservice.card.dto.CardDTO;

public class TransactionCardDTO {
	
	private Integer id_transaction_card;
	private CardDTO card;
	
	public TransactionCardDTO() {
		super();
	}

	public TransactionCardDTO(Integer id_transaction_card, CardDTO card) {
		super();
		this.id_transaction_card = id_transaction_card;
		this.card = card;
	}


	public Integer getId() {
		return id_transaction_card;
	}


	public void setId(Integer id_transaction_card) {
		this.id_transaction_card = id_transaction_card;
	}


	public CardDTO getCard() {
		return card;
	}


	public void setCard(CardDTO card) {
		this.card = card;
	}


	@Override
	public String toString() {
		return "TransactionCardDTO [id_transaction_card=" + id_transaction_card + ", card=" + card + "]";
	}
	
}

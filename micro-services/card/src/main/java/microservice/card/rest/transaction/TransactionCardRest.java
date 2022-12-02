package microservice.card.rest.transaction;

public interface TransactionCardRest {
	public void updateCardToBuy(TransactionCardDTO transactionCardDTO);
	public void updateCardToSell(TransactionCardDTO transactionCardDTO);
}


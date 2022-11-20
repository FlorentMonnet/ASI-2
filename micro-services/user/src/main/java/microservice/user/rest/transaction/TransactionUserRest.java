package microservice.user.rest.transaction;

public interface TransactionUserRest {
	public void updateUserToBuy(TransactionUserDTO transactionUserDTO);
	public void updateUserToSell(TransactionUserDTO transactionUserDTO);
}


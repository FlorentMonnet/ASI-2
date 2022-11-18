package microservice.transaction.mapper;

import microservice.transaction.dto.TransactionDTO;
import microservice.transaction.entity.Transaction;

public class TransactionMapper {

	public static Transaction fromTransactionDTOToTransaction(TransactionDTO transactionDTO) {
		Transaction transaction=new Transaction();
		
		transaction.setAction(transactionDTO.getAction());
		transaction.setCardId(transactionDTO.getCardId());
		transaction.setId(transactionDTO.getId());
		transaction.setTimeSt(transactionDTO.getTimeSt());
		transaction.setUserId(transactionDTO.getUserId());
		transaction.setCardOk(transactionDTO());
		
		return transaction;
	}
	
	public static TransactionDTO fromTransactionDTOToTransaction(Transaction transaction) {
		TransactionDTO transactionDTO=new TransactionDTO();
		transactionDTO.setAction(transaction.getAction());
		transactionDTO.setCardId(transaction.getCardId());
		transactionDTO.setId(transaction.getId());
		transactionDTO.setTimeSt(transaction.getTimeSt());
		transactionDTO.setUserId(transaction.getUserId());
		return transactionDTO;
	}
}

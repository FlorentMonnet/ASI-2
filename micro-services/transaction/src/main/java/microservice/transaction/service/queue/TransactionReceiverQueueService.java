package microservice.transaction.service.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import microservice.transaction.entity.Transaction;
import microservice.transaction.service.TransactionService;
@Service
public class TransactionReceiverQueueService {
	
	@Autowired
	TransactionService transactionService;
	
	@JmsListener(destination = "buy", containerFactory = "connectionFactory")
	public void receiveBuy(Transaction transaction) {
	  System.out.println("<Received in buy queue <" + transaction.toString() + ">");
	  transactionService.addTransaction(transaction);
	}

	@JmsListener(destination = "updateTransaction", containerFactory = "connectionFactory")
	public void updateTransaction(Transaction transaction) {
	  System.out.println("<Received in updateTransaction queue <" + transaction.toString() + ">");
	  transactionService.updateTransaction(transaction);
	}
	
	@JmsListener(destination = "updateIsCardOk", containerFactory = "connectionFactory")
	public void receiveUpdateIsCardOk(Integer idTransaction) {
	  System.out.println("<Received in UpdateIsCardOk queue <" + idTransaction + ">");
	  transactionService.updateIsCardOk(idTransaction);
	}
	
	@JmsListener(destination = "updateIsUserOk", containerFactory = "connectionFactory")
	public void receiveUpdateIsUserOk(Integer idTransaction) {
	  System.out.println("<Received in updateIsUserOk queue <" + idTransaction + ">");
	  transactionService.updateIsUserOk(idTransaction);
	}

}

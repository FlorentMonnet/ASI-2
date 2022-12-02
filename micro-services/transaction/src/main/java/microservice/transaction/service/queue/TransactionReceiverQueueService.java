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
	  transactionService.buyTransaction(transaction);
	}
	
	@JmsListener(destination = "sell", containerFactory = "connectionFactory")
	public void receiveSell(Transaction transaction) {
	  System.out.println("<Received in sell queue <" + transaction.toString() + ">");
	  transactionService.sellTransaction(transaction);
	}

	@JmsListener(destination = "updateTransaction", containerFactory = "connectionFactory")
	public void updateTransaction(Transaction transaction) {
	  System.out.println("<Received in updateTransaction queue <" + transaction.toString() + ">");
	  transactionService.updateTransaction(transaction);
	}
	
	@JmsListener(destination = "updateIsCardOkToBuy", containerFactory = "connectionFactory")
	public void receiveUpdateIsCardOkToBuy(Integer idTransaction) {
	  System.out.println("<Received in UpdateIsCardOk queue <" + idTransaction + ">");
	  transactionService.updateIsCardOkToBuy(idTransaction);
	}
	
	@JmsListener(destination = "updateIsUserOkToBuy", containerFactory = "connectionFactory")
	public void receiveUpdateIsUserOToBuy(Integer idTransaction) {
	  System.out.println("<Received in updateIsUserOk queue <" + idTransaction + ">");
	  transactionService.updateIsUserOkToBuy(idTransaction);
	}
	
	@JmsListener(destination = "updateIsCardOkToSell", containerFactory = "connectionFactory")
	public void receiveUpdateIsCardOkToSell(Integer idTransaction) {
	  System.out.println("<Received in UpdateIsCardOk queue <" + idTransaction + ">");
	  transactionService.updateIsCardOkToSell(idTransaction);
	}
	
	@JmsListener(destination = "updateIsUserOkToSell", containerFactory = "connectionFactory")
	public void receiveUpdateIsUserOkToSell(Integer idTransaction) {
	  System.out.println("<Received in updateIsUserOk queue <" + idTransaction + ">");
	  transactionService.updateIsUserOkToSell(idTransaction);
	}

}

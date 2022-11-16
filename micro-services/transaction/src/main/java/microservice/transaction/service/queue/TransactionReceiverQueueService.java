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
	
	@JmsListener(destination = "createTransaction", containerFactory = "connectionFactory")
	public void receiveCreationUser(Transaction transaction) {
	  System.out.println("<Received in creation queue <" + transaction.toString() + ">");
	  //transactionService.buyCard(transaction);
	}

	@JmsListener(destination = "updateTransaction", containerFactory = "connectionFactory")
	public void receiveUpdateUser(Transaction transaction) {
	  System.out.println("<Received in update queue <" + transaction.toString() + ">");
	  //transactionService.updateCard(card);
	}

}

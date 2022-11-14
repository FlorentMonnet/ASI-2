package microservice.transaction.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservice.transaction.entity.Transaction;
import microservice.transaction.entity.TransactionOrder;
import microservice.transaction.service.TransactionService;


//ONLY FOR TEST NEED ALSO TO ALLOW CROOS ORIGIN ON WEB BROWSER SIDE
@CrossOrigin
@RestController
@RequestMapping(value="/store")
public class TransactionController {

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/buy")
	private boolean getAllCards(@RequestBody TransactionOrder order) {
		return transactionService.buyCard(order.getUser_id(), order.getCard_id());

	}

	@RequestMapping(method = RequestMethod.POST, value = "/sell")
	private boolean getCard(@RequestBody TransactionOrder order) {
		return transactionService.sellCard(order.getUser_id(), order.getCard_id());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/transaction")
	private List<Transaction> getCard() {
		return transactionService.getAllTransactions();
	}

}


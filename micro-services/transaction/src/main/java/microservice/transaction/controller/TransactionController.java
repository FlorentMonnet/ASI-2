package microservice.transaction.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import microservice.transaction.dto.TransactionCardDTO;
import microservice.transaction.dto.TransactionUserDTO;
import microservice.transaction.entity.Transaction;
import microservice.transaction.entity.TransactionOrder;
import microservice.transaction.service.TransactionService;


@RestController
@RequestMapping(value="/api/transaction-microservice")
public class TransactionController {

	@Autowired
	private final TransactionService transactionService;
	

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/buy")
	private HttpServletResponse buyCard(@RequestBody TransactionOrder order, HttpServletResponse response) {
		return transactionService.buyCard(order.getUser_id(), order.getCard_id(), response);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/sell")
	private HttpServletResponse sellCard(@RequestBody TransactionOrder order, HttpServletResponse response) {
		return transactionService.sellCard(order.getUser_id(), order.getCard_id(), response);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/card-ok")
	private void updateIsCardOk(@RequestBody TransactionCardDTO transactionCardDTO) {
		transactionService.addIdTransactionToUpdateIsCardOk(transactionCardDTO.getId());
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user-ok")
	private void updateIsUserOk(@RequestBody TransactionUserDTO transactionUserDTO) {
		transactionService.addIdTransactionToUpdateIsUserOk(transactionUserDTO.getId());
	}
	@RequestMapping(method = RequestMethod.GET, value = "/transaction")
	private List<Transaction> getAllCards() {
		return transactionService.getAllTransactions();
	}

}


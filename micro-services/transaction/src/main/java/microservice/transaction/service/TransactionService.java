package microservice.transaction.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.transaction.dto.TransactionCardDTO;
import microservice.transaction.dto.TransactionUserDTO;
import microservice.transaction.entity.Transaction;
import microservice.transaction.entity.TransactionAction;
import microservice.transaction.repository.TransactionRepository;
import microservice.transaction.rest.card.CardDTO;
import microservice.transaction.rest.card.CardRestClient;
import microservice.transaction.rest.user.UserDTO;
import microservice.transaction.rest.user.UserRestClient;
import microservice.transaction.service.queue.TransactionSenderQueueService;

@Service
public class TransactionService {
	
	@Autowired
	private CardRestClient cardRestClient;
	
	@Autowired
	private UserRestClient userRestClient;
	
	@Autowired
	private TransactionRepository storeRepository;
	
	@Autowired
	private TransactionSenderQueueService transactionSenderQueueService;


	public TransactionService() {
	}

	public HttpServletResponse buyCard(Integer user_id, Integer card_id, HttpServletResponse response) {
		Optional<UserDTO> optionalUserDTO = userRestClient.getUserById(user_id);
		Optional<CardDTO> optionalCardDTO = cardRestClient.getCardbById(card_id);
		if (!optionalUserDTO.isPresent() || !optionalCardDTO.isPresent()) {
			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "User or Card not found");
				return response;
			} catch (IOException e) {
				e.printStackTrace();
				return response;
			}

		}
		Transaction transaction = new Transaction(user_id, card_id, TransactionAction.BUY,false,false);
		this.addTransactionToBuyQueue(transaction);
		return null;
	}

	public HttpServletResponse sellCard(Integer user_id, Integer card_id, HttpServletResponse response) {
		Optional<UserDTO> optionalUserDTO = userRestClient.getUserById(user_id);
		Optional<CardDTO> optionalCardDTO = cardRestClient.getCardbById(card_id);
		if (!optionalUserDTO.isPresent() || !optionalCardDTO.isPresent()) {
			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "User or Card not found");
				return response;
			} catch (IOException e) {
				e.printStackTrace();
				return response;
			}
		}
		UserDTO userDTO = optionalUserDTO.get();
		CardDTO cardDTO = optionalCardDTO.get();
		


		// Mise à null de l'id_user de la Card
		cardDTO.setId_user(null);
		//cardRestClient.updateCard(c);
		
		// Mise à jour de l'argent de l'utilisateur
		userDTO.setMoney(userDTO.getMoney() + cardDTO.getPrice());
		userRestClient.updateUser(userDTO);
		
		// Création d'un transaction de type SELL
		Transaction sT = new Transaction(user_id, card_id, TransactionAction.SELL,false,false);
		storeRepository.save(sT);
		
		return null;
	}

	public List<Transaction> getAllTransactions() {
		List<Transaction> sTList = new ArrayList<>();
		this.storeRepository.findAll().forEach(sTList::add);
		return sTList;

	}
	
	public Optional<Transaction> getTransactionById(Integer id) {
		System.out.println("GET TRANSACTIOn BY ID: "+id);
		return storeRepository.findById(id);
	}
	
	public void addTransactionToBuyQueue(Transaction transaction) {
		transactionSenderQueueService.addTransactionToBuyQueue(transaction);
	}
	
	public void addTransactionToUpdateQueue(Transaction transaction) {
		transactionSenderQueueService.addTransactionToUpdateQueue(transaction);
	}
	
	public void addIdTransactionToUpdateIsCardOk(Integer idTransaction) {
		transactionSenderQueueService.addIdTransactionToIsCardOkQueue(idTransaction);
	}
	
	public void addIdTransactionToUpdateIsUserOk(Integer idTransaction) {
		transactionSenderQueueService.addIdTransactionToIsUserOkQueue(idTransaction);
	}

	public void addTransaction(Transaction transaction) {
		transaction = storeRepository.save(transaction);
		Optional<UserDTO> optionalUserDTO = userRestClient.getUserById(transaction.getUserId());
		Optional<CardDTO> optionalCardDTO = cardRestClient.getCardbById(transaction.getCardId());
		UserDTO userDTO = optionalUserDTO.get();
		CardDTO cardDTO = optionalCardDTO.get();
		if (userDTO.getMoney() > cardDTO.getPrice()) {
					
				
				System.out.println("[TransactionService] [buyCard]"+transaction.toString());
				userDTO.setMoney(userDTO.getMoney() - cardDTO.getPrice());
				TransactionUserDTO transactionUserDTO = new TransactionUserDTO(transaction.getId(),userDTO);
				userRestClient.updateUserToPay(transactionUserDTO);
		}

	}

	public void updateTransaction(Transaction transaction) {
		storeRepository.save(transaction);
	}
	
	public void updateIsCardOk(Integer idTransaction) {
		Optional<Transaction> optionalTransaction = getTransactionById(idTransaction);
		
		if(optionalTransaction.isPresent())
		{
			Transaction transaction = optionalTransaction.get();
			
			transaction.setCardOk(true);
			transaction.setTimeSt(new Timestamp(System.currentTimeMillis()));
			storeRepository.save(transaction);
			// TODO :send notif to inform user that transaction is finished
		}
		
	}
	
	public void updateIsUserOk(Integer idTransaction) {
		System.out.println("updateIsUserOk");
		Optional<Transaction> optionalTransaction = getTransactionById(idTransaction);
		if(optionalTransaction.isPresent())
		{
			Transaction transaction = optionalTransaction.get();
			System.out.println("optionalTransaction");
			Optional<UserDTO> optionalUserDTO = userRestClient.getUserById(transaction.getUserId());
			Optional<CardDTO> optionalCardDTO = cardRestClient.getCardbById(transaction.getCardId());
			UserDTO userDTO = optionalUserDTO.get();
			CardDTO cardDTO = optionalCardDTO.get();
			transaction.setUserOk(true);
			transaction.setTimeSt(new Timestamp(System.currentTimeMillis()));
			storeRepository.save(transaction);
			cardDTO.setId_user(userDTO.getId_user());
			TransactionCardDTO transactionCardDTO = new TransactionCardDTO(transaction.getId(),cardDTO);
			cardRestClient.updateCardToPay(transactionCardDTO);
		}
		
	}
}

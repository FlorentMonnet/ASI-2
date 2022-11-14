package microservice.transaction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import microservice.transaction.entity.Transaction;
import microservice.transaction.repository.TransactionRepository;

public class TransactionService {
	//private final CardModelService cardService;
	//private final UserService userService;
	private final TransactionRepository storeRepository;

	public TransactionService(/*CardModelService cardService, UserService userService,*/ TransactionRepository storeRepository) {
		//this.cardService = cardService;
		//this.userService = userService;
		this.storeRepository = storeRepository;
	}

	public boolean buyCard(Integer user_id, Integer card_id) {
		/*Optional<UserModel> u_option = userService.getUser(user_id);
		Optional<CardModel> c_option = cardService.getCard(card_id);
		if (!u_option.isPresent() || !c_option.isPresent()) {
			return false;
		}
		UserModel u = u_option.get();
		CardModel c = c_option.get();
		if (u.getAccount() > c.getPrice()) {
			u.addCard(c);
			u.setAccount(u.getAccount() - c.getPrice());
			userService.updateUser(u);
			StoreTransaction sT = new StoreTransaction(user_id, card_id, StoreAction.BUY);
			storeRepository.save(sT);
			return true;
		} else {
			return false;
		}*/
		return true;
	}

	public boolean sellCard(Integer user_id, Integer card_id) {
		/*Optional<UserModel> u_option = userService.getUser(user_id);
		Optional<CardModel> c_option = cardService.getCard(card_id);
		if (!u_option.isPresent() || !c_option.isPresent()) {
			return false;
		}
		UserModel u = u_option.get();
		CardModel c = c_option.get();

		c.setUser(null);
		cardService.updateCard(c);
		u.setAccount(u.getAccount() + c.computePrice());
		userService.updateUser(u);
		StoreTransaction sT = new StoreTransaction(user_id, card_id, StoreAction.SELL);
		storeRepository.save(sT);*/
		return true;
	}

	public List<Transaction> getAllTransactions() {
		List<Transaction> sTList = new ArrayList<>();
		this.storeRepository.findAll().forEach(sTList::add);
		return sTList;

	}
}

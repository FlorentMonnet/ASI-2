package microservice.transaction.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.transaction.entity.Transaction;
import microservice.transaction.entity.TransactionAction;
import microservice.transaction.repository.TransactionRepository;
import microservice.transaction.rest.card.CardDTO;
import microservice.transaction.rest.card.CardRestClient;
import microservice.transaction.rest.user.UserDTO;
import microservice.transaction.rest.user.UserRestClient;

@Service
public class TransactionService {
	@Autowired
	private CardRestClient cardService = new CardRestClient();
	@Autowired
	private UserRestClient userService= new UserRestClient();
	private final TransactionRepository storeRepository;

	public TransactionService(CardRestClient cardService,  UserRestClient userService,TransactionRepository storeRepository) {
		this.cardService = cardService;
		this.userService = userService;
		this.storeRepository = storeRepository;
	}

	public HttpServletResponse buyCard(Integer user_id, Integer card_id, HttpServletResponse response) {
		Optional<UserDTO> u_option = userService.getUserById(user_id);
		Optional<CardDTO> c_option = cardService.getCardbById(card_id);
		if (!u_option.isPresent() || !c_option.isPresent()) {
			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "User or Card not found");
				return response;
			} catch (IOException e) {
				e.printStackTrace();
				return response;
			}

		}
		UserDTO u = u_option.get();
		CardDTO c = c_option.get();
		if (u.getMoney() > c.getPrice()) {
			
			// Mise à jour de l'argent de l'acheteur
			u.setMoney(u.getMoney() - c.getPrice());
			userService.updateUser(u);
			// Mise à jour de l'id_user de la card
			c.setId_user(u.getId_user());
			cardService.updateCard(c);
			// Création d'un transaction de type BUY
			Transaction sT = new Transaction(user_id, card_id, TransactionAction.BUY);
			storeRepository.save(sT);
			return null;
		} else {
			try {
				response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Not enough money");
				return response;
			} catch (IOException e) {
				e.printStackTrace();
				return response;
			}


		}
	}

	public HttpServletResponse sellCard(Integer user_id, Integer card_id, HttpServletResponse response) {
		Optional<UserDTO> u_option = userService.getUserById(user_id);
		Optional<CardDTO> c_option = cardService.getCardbById(card_id);
		if (!u_option.isPresent() || !c_option.isPresent()) {
			try {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "User or Card not found");
				return response;
			} catch (IOException e) {
				e.printStackTrace();
				return response;
			}
		}
		UserDTO u = u_option.get();
		CardDTO c = c_option.get();

		// Mise à null de l'id_user de la Card
		c.setId_user(null);
		cardService.updateCard(c);
		
		// Mise à jour de l'argent de l'utilisateur
		u.setMoney(u.getMoney() + c.getPrice());
		userService.updateUser(u);
		
		// Création d'un transaction de type SELL
		Transaction sT = new Transaction(user_id, card_id, TransactionAction.SELL);
		storeRepository.save(sT);
		
		return null;
	}

	public List<Transaction> getAllTransactions() {
		List<Transaction> sTList = new ArrayList<>();
		this.storeRepository.findAll().forEach(sTList::add);
		return sTList;

	}
}

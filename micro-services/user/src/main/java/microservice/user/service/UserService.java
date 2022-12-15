package microservice.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import microservice.common.TransactionUserDTO;
import microservice.common.TransactionUserRestClient;

import microservice.common.UserLoginDTO;
import microservice.common.UserRegisterDTO;

import microservice.user.entity.User;
import microservice.user.mapper.UserMapper;
import microservice.user.mapper.UserRegisterMapper;
import microservice.user.repository.UserRepository;

import microservice.user.rest.auth.AuthRestClient;
import microservice.common.TransactionUserDTO;
import microservice.common.TransactionUserRestClient;

import microservice.user.service.queue.UserSenderQueueService;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	UserMapper userMapper;
	
	@Autowired
	UserRegisterMapper userRegisterMapper;
	
	@Autowired
	UserSenderQueueService userSenderQueueService;

	@Autowired
	AuthRestClient authRestClient;

	TransactionUserRestClient transactionUserRestClient;
	

	
	public User getUserById(Integer idUser) {
		return userRepository.findById(idUser).orElseThrow(() -> new RuntimeException());
	}
	
	public Integer login(UserLoginDTO userLoginDTO) {
		Optional<User> optionalUser = this.userRepository.findByMail(userLoginDTO.getMail());
		Integer id = 0;
		if(optionalUser.isPresent())
		{
			User user = optionalUser.get();
			UserRegisterDTO userRegisterFound = userRegisterMapper.toDTO(user);
			UserRegisterDTO userRegisterLogging = userRegisterMapper.toDTO(userLoginDTO);
			List<UserRegisterDTO> usersRegister = new ArrayList();
			usersRegister.add(userRegisterFound);
			usersRegister.add(userRegisterLogging);
			
			if(authRestClient.checkPassword(usersRegister))
			{
				id = user.getId_user();
			}
		}
		return id;
	}
	
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;

	}
	
	public String addUserToCreationQueue(User user) {
		boolean result = userSenderQueueService.addUserToCreationQueue(user);
		return result ? "Creation de l'utilisateur en cours" : "";
	}
	
	public String addUserToRegisterQueue(UserRegisterDTO userRegisterDTO) {
		boolean result = userSenderQueueService.addUserToRegisterQueue(userRegisterDTO);
		return result ? "Creation de l'utilisateur en cours" : "";
	}
	
	public String addUserToUpdateQueue(User user) {
		boolean result = userSenderQueueService.addUserToUpdateQueue(user);
		return result ? "Mise à jour de l'utilisateur en cours" : "";
	}
	
	public String addTransactionUserToPayQueue(TransactionUserDTO transactionUserDTO) {
		boolean result = userSenderQueueService.addTransactionUserToPayQueue(transactionUserDTO);
		return result ? "Mise à jour de de l'utilisateur en cours" : "";
	}
	
	public String addTransactionUserToSellQueue(TransactionUserDTO transactionUserDTO) {
		boolean result = userSenderQueueService.addTransactionUserToSellQueue(transactionUserDTO);
		return result ? "Mise à jour de de l'utilisateur en cours" : "";
	}
	
	
	public User addUser(User user) {
		userRepository.save(user);
		return user;
	}
	
	public User register(UserRegisterDTO userRegisterDTO) {
		String password = authRestClient.encryptPassword(userRegisterDTO);
		User user = new User(
					userRegisterDTO.getName(), 
					userRegisterDTO.getSurname(), 
					userRegisterDTO.getMoney(),
					password, 
					userRegisterDTO.getIsAdmin(), 
					userRegisterDTO.getMail()
				);
		userRepository.save(user);
		return user;
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	

	public User updateUser(User user) {
		return userRepository.save(user);
	}
	
	public void updateUserToPay(TransactionUserDTO transactionUserDTO) {
		userRepository.save(userMapper.toModel(transactionUserDTO.getUser()));
		transactionUserRestClient.updateUserToBuy(transactionUserDTO);
	}
	
	public void updateUserToSell(TransactionUserDTO transactionUserDTO) {
		userRepository.save(userMapper.toModel(transactionUserDTO.getUser()));
		transactionUserRestClient.updateUserToSell(transactionUserDTO);
	}
}

package microservice.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.common.TransactionUserDTO;
import microservice.common.TransactionUserRestClient;
import microservice.user.entity.User;
import microservice.user.mapper.UserMapper;
import microservice.user.repository.UserRepository;
import microservice.user.service.queue.UserSenderQueueService;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	
	@Autowired
	UserMapper userMapper;
	
	
	@Autowired
	UserSenderQueueService userSenderQueueService;

	@Autowired
	TransactionUserRestClient transactionUserRestClient;
	
	public User getUserById(Integer idUser) {
		return userRepository.findById(idUser).orElseThrow(() -> new RuntimeException());
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
	
	public String addUserToUpdateQueue(User user) {
		boolean result = userSenderQueueService.addUserToUpdateQueue(user);
		return result ? "Mise à jour de l'utilisateur en cours" : "";
	}
	
	public String addTransactionUserToPayQueue(TransactionUserDTO transactionUserDTO) {
		boolean result = userSenderQueueService.addTransactionUserToPayQueue(transactionUserDTO);
		return result ? "Mise à jour de de l'utilisateur en cours" : "";
	}
	
	
	public User addUser(User user) {
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
		transactionUserRestClient.updateUserToPay(transactionUserDTO);
	}
}

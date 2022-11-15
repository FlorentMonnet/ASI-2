package microservice.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.user.dto.UserDTO;
import microservice.user.entity.User;
import microservice.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User getUserById(Integer idUser) {
		return userRepository.findById(idUser).orElseThrow(() -> new RuntimeException());
	}
	
	public List<User> getUsers() {
		List<User> userList = new ArrayList<>();
		userRepository.findAll().forEach(userList::add);
		return userList;

	}
	
	public User addUser(User user) {
		System.out.println(user.toString());
		// needed to avoid detached entity passed to persist error
		userRepository.save(user);
		/*List<CardModel> cardList = cardModelService.getRandCard(5);
		for (CardModel card : cardList) {
			u.addCard(card);
		}*/
		return user;
	}
	
	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}
	
	public User updateUser(User user) {
		return userRepository.save(user);
	}
}

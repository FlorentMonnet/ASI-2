package microservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservice.user.entity.User;
import microservice.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public User getUserById(Integer idUser) {
		return userRepository.findById(idUser).orElseThrow(() -> new RuntimeException());
	}
}

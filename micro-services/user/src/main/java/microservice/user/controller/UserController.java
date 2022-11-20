package microservice.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.user.dto.UserDTO;
import microservice.user.dto.UserLoginDTO;
import microservice.user.dto.UserRegisterDTO;
import microservice.user.entity.User;
import microservice.user.mapper.UserMapper;
import microservice.user.rest.transaction.TransactionUserDTO;
import microservice.user.service.UserService;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/user-microservice")
public class UserController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/users")
	public List<UserDTO> getAllUsers() {
		return userMapper.toDTOList(userService.getUsers());
	}

	@GetMapping("/user/{id_user}")
	public UserDTO getUserById(@PathVariable Integer id_user) {
		return userMapper.toDTO(userService.getUserById(id_user));
	}
	
	@PostMapping("/user")
	public String register(@RequestBody UserDTO user) {
		return userService.addUserToCreationQueue(userMapper.toModel(user));
	}
	@PostMapping("/register")
	public String register(@RequestBody UserRegisterDTO userRegisterDTO) {
		return userService.addUserToRegisterQueue(userRegisterDTO);
	}
	
	@PostMapping("/auth")
	public Integer login(@RequestBody UserLoginDTO userLoginDTO) {
		return userService.login(userLoginDTO);
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
	}
	
	@PatchMapping("/user/{id}")
	public String updateUser(@RequestBody UserDTO user,@PathVariable Integer id) {
		user.setId(Integer.valueOf(id));
		return userService.addUserToUpdateQueue(userMapper.toModel(user));
	}
	
	@PatchMapping("/buy-user/{id}")
	public void updateUserToPay(@RequestBody TransactionUserDTO transactionCardDTO,@PathVariable Integer id) {
		userService.addTransactionUserToPayQueue(transactionCardDTO);
	}
	
	@PatchMapping("/sell-user/{id}")
	public void updateUserToSell(@RequestBody TransactionUserDTO transactionCardDTO,@PathVariable Integer id) {
		userService.addTransactionUserToSellQueue(transactionCardDTO);
	}

}

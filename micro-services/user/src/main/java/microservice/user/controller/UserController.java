package microservice.user.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservice.user.dto.UserDTO;
import microservice.user.mapper.UserMapper;
import microservice.user.service.UserService;

@RestController
@RequestMapping("/api/user-microservice")
public class UserController{
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserMapper userMapper;
	
	@GetMapping("/user/{id_user}")
	public UserDTO getUserById(@PathVariable Integer id_user) {
		return userMapper.toDTO(userService.getUserById(id_user));
	}
}

package microservice.authentication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import microservice.authentication.dto.UserRegisterDTO;
import microservice.authentication.service.AuthenticationService;

@CrossOrigin
@RestController
@RequestMapping("/api/auth-microservice")
public class AuthenticationController {


	@Autowired
	AuthenticationService authService;
	
	// POST
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value="/admin/auth/createToken")
	public String createToken(@RequestBody UserRegisterDTO dto) {
		return authService.createToken(dto);
	}
	
	@PostMapping(value="/admin/auth/encryptPassword")
	public String encryptPassword(@RequestBody UserRegisterDTO dto) {
		return authService.encryptPassword(dto);
	}
	
	@PostMapping(value="/admin/auth/checkPassword")
	public boolean checkPassword(@RequestBody List<UserRegisterDTO> dtoUserFoundAndUserLogging) {
		return authService.checkPassword(dtoUserFoundAndUserLogging);
	}
}
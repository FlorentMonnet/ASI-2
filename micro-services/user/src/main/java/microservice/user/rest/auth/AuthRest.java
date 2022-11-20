package microservice.user.rest.auth;

import java.util.List;

import microservice.user.dto.UserRegisterDTO;

public interface AuthRest {
	public String encryptPassword(UserRegisterDTO userRegisterDTO);
	public boolean checkPassword(List<UserRegisterDTO> userRegisterDTO);
}


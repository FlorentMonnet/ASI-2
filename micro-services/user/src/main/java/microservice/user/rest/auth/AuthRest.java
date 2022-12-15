package microservice.user.rest.auth;

import java.util.List;

import microservice.common.UserRegisterDTO;

public interface AuthRest {
	public String encryptPassword(UserRegisterDTO userRegisterDTO);
	public boolean checkPassword(List<UserRegisterDTO> userRegisterDTO);
}


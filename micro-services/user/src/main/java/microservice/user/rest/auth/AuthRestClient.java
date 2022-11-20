package microservice.user.rest.auth;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import microservice.user.dto.UserRegisterDTO;

@Component
public class AuthRestClient implements AuthRest{
	private static final String URL_AUTH = "http://reverse-proxy:80/api/auth-microservice/";
	
	public AuthRestClient() {
	}

	@Override
	public String encryptPassword(UserRegisterDTO userRegisterDTO) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL_AUTH + "encryptPassword", userRegisterDTO, String.class);
	}

	@Override
	public boolean checkPassword(List<UserRegisterDTO> usersRegisterDTO) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL_AUTH + "checkPassword", usersRegisterDTO, boolean.class);
	}
}

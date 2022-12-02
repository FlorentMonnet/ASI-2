package microservice.common;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class UserRestClient implements UserRest{
	
	private static final String URL_USER_MICROSERVICE = "http://reverse-proxy:80/api/user-microservice"; 
	private static final String URL_USER = URL_USER_MICROSERVICE + "/user/"; 
	private static final String URL_PAY_USER = URL_USER_MICROSERVICE + "/pay-user/"; 

	public UserRestClient() {
		
	}

	@Override
	public Optional<UserDTO> getUserById(Integer id_user) {
		System.out.println("[UserRestClient] [getUserById} id_user:"+id_user);
		RestTemplate restTemplate = new RestTemplate();
		Optional<UserDTO> res = Optional.of(restTemplate.getForObject(URL_USER + "/" + id_user, UserDTO.class));
		return res;
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		System.out.println("[UserRestClient] [updateUser] " +userDTO.toString());
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.exchange(URL_USER + userDTO.getId_user(), HttpMethod.PATCH, new HttpEntity<UserDTO>(userDTO), String.class);
	}
	
	@Override
	public void updateUserToPay(TransactionUserDTO transactionUserDTO) {
		System.out.println("[UserRestClient] [updateUserToPay] " + transactionUserDTO.toString());
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.exchange(URL_PAY_USER + transactionUserDTO.getId(), HttpMethod.PATCH, new HttpEntity<TransactionUserDTO>(transactionUserDTO), String.class);
	}


}

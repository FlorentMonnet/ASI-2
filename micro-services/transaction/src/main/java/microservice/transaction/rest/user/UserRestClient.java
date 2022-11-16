package microservice.transaction.rest.user;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class UserRestClient implements UserRest{
	
	private static final String URL_PUBLIC = "http://reverse-proxy:80/api/user-microservice/user"; 


	public UserRestClient() {
		
	}

	@Override
	public Optional<UserDTO> getUserById(Integer id_user) {
		RestTemplate restTemplate = new RestTemplate();
		Optional<UserDTO> res = Optional.of(restTemplate.getForObject(URL_PUBLIC + "/" + id_user, UserDTO.class));
		return res;
	}

	@Override
	public void updateUser(UserDTO dto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.patchForObject(URL_PUBLIC + "/" + dto.getId_user(), dto, ResponseEntity.class);
		
	}


}

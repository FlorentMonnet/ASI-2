package microservice.user.rest.card;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserRestClient implements UserRest{
	private static final String URL_CARD = "http://reverse-proxy:80/api/card-microservice/";
	
	public UserRestClient() {
	}


	@Override
	public String initUserCards(Integer id_user) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(URL_CARD + "init-user-cards", id_user, String.class);
	}
}

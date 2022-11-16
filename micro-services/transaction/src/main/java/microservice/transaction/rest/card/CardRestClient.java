package microservice.transaction.rest.card;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import microservice.transaction.rest.user.UserDTO;
@Component
public class CardRestClient implements CardRest{
	
	private static final String URL_PUBLIC = "http://reverse-proxy:80/api/card-microservice/card"; 

	public CardRestClient() {
	}

	@Override
	public List<CardDTO> getAllCards() {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO[] response = restTemplate.getForEntity(URL_PUBLIC, CardDTO[].class).getBody();
		return List.of(response);
	}

	@Override
	public Optional<CardDTO> getCardbById(Integer id_card) {
		RestTemplate restTemplate = new RestTemplate();
		Optional<CardDTO> res = Optional.of(restTemplate.getForObject(URL_PUBLIC + "/" + id_card, CardDTO.class));
		return res;
	}

	@Override
	public List<CardDTO> getCardsbByIdFamily(Integer id_family) {
		RestTemplate restTemplate = new RestTemplate();
		CardDTO[] res = restTemplate.getForEntity(URL_PUBLIC + "/family/" + id_family, CardDTO[].class).getBody();
		return List.of(res);
	}

	@Override
	public void createCard(CardDTO dto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_PUBLIC, dto, ResponseEntity.class);
	}
	
	@Override
	public void updateCard(CardDTO dto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.patchForObject(URL_PUBLIC + "/" + dto.getId_user(), dto, ResponseEntity.class);	
	}

}

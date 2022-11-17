package microservice.transaction.rest.card;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


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
	public CardDTO updateCard(CardDTO dto) {
		System.out.println(dto.toString());
		RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
		restTemplate.exchange(URL_PUBLIC + "/" + dto.getId(), HttpMethod.PATCH, new HttpEntity<CardDTO>(dto), CardDTO.class);
		return dto;
	}

}

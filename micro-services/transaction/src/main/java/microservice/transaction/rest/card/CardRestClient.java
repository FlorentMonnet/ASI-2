package microservice.transaction.rest.card;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class CardRestClient implements CardRest{
	
	private static final String URL_PUBLIC = "http://reverse-proxy:80/api/card-microservice/card"; 
	private RestTemplate restTemplate;
	
	public CardRestClient() {
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	}

	@Override
	public List<CardDTO> getAllCards() {
		CardDTO[] response = restTemplate.getForEntity(URL_PUBLIC, CardDTO[].class).getBody();
		return List.of(response);
	}

	@Override
	public Optional<CardDTO> getCardbById(Integer id_card) {
		Optional<CardDTO> res = Optional.of(restTemplate.getForObject(URL_PUBLIC + "/" + id_card, CardDTO.class));
		return res;
	}

	@Override
	public List<CardDTO> getCardsbByIdFamily(Integer id_family) {
		CardDTO[] res = restTemplate.getForEntity(URL_PUBLIC + "/family/" + id_family, CardDTO[].class).getBody();
		return List.of(res);
	}

	@Override
	public void createCard(CardDTO dto) {
		restTemplate.postForObject(URL_PUBLIC, dto, ResponseEntity.class);
	}
	
	@Override
	public void updateCard(CardDTO dto) {
		System.out.println(dto.toString());
		restTemplate.exchange(URL_PUBLIC + "/" + dto.getId(), HttpMethod.PATCH, new HttpEntity<CardDTO>(dto), CardDTO.class);
	}

}

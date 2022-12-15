package microservice.common;

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
	
	private static final String URL_CARD_MICROSERVICE = "http://reverse-proxy:80/api/card-microservice"; 
	private static final String URL_CARD = URL_CARD_MICROSERVICE + "/card/"; 
	private static final String URL_BUY_CARRD = URL_CARD_MICROSERVICE + "/buy-card/"; 
	private static final String URL_SELL_CARRD = URL_CARD_MICROSERVICE + "/sell-card/"; 
	
	private RestTemplate restTemplate;
	
	public CardRestClient() {
		restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
	}

	@Override
	public List<CardDTO> getAllCards() {
		System.out.println("[CardRestClient] [getAllCards]");
		CardDTO[] response = restTemplate.getForEntity(URL_CARD , CardDTO[].class).getBody();
		return List.of(response);
	}

	@Override
	public Optional<CardDTO> getCardbById(Integer id_card) {
		System.out.println("[CardRestClient] [getCardbById] id_card:" +id_card);
		Optional<CardDTO> res = Optional.of(restTemplate.getForObject(URL_CARD + id_card, CardDTO.class));
		return res;
	}

	@Override
	public List<CardDTO> getCardsbByIdFamily(Integer id_family) {
		System.out.println("[CardRestClient] [getCardsbByIdFamily] id_family:" +id_family);
		CardDTO[] res = restTemplate.getForEntity(URL_CARD + "/family/" + id_family, CardDTO[].class).getBody();
		return List.of(res);
	}

	@Override
	public void createCard(CardDTO cardDTO) {
		System.out.println("[CardRestClient] [createCard] :" +cardDTO.toString());
		restTemplate.postForObject(URL_CARD, cardDTO, ResponseEntity.class);
	}
	
	@Override
	public void updateCardToBuy(TransactionCardDTO transactionCardDTO) {
		System.out.println("[CardRestClient] [updateCardToBuy] " +transactionCardDTO.toString());
		restTemplate.exchange(URL_BUY_CARRD + transactionCardDTO.getId(), HttpMethod.PATCH, new HttpEntity<TransactionCardDTO>(transactionCardDTO), String.class);
	}
	
	@Override
	public void updateCardToSell(TransactionCardDTO transactionCardDTO) {
		System.out.println("[CardRestClient] [updateCardToSell] " +transactionCardDTO.toString());
		restTemplate.exchange(URL_SELL_CARRD + transactionCardDTO.getId(), HttpMethod.PATCH, new HttpEntity<TransactionCardDTO>(transactionCardDTO), String.class);
	}

}

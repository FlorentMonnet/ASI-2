package microservice.card.rest.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionCardRestClient implements TransactionCardRest{
	
	private static final String URL_TRANSACTION = "http://reverse-proxy:80/api/transaction-microservice"; 
	
	
	public TransactionCardRestClient() {
	}

	@Override
	public void updateCardToPay(TransactionCardDTO transactionCardDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION + "/card-ok", transactionCardDTO, ResponseEntity.class);
	}


}

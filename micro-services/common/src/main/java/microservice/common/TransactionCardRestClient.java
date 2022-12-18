package microservice.common;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionCardRestClient implements TransactionCardRest{
	
	private static final String URL_TRANSACTION = "http://reverse-proxy:80/api/transaction-microservice"; 
	private static final String URL_TRANSACTION_BUY = URL_TRANSACTION + "/buy-card-ok"; 
	private static final String URL_TRANSACTION_SELL = URL_TRANSACTION + "/sell-card-ok"; 
	public TransactionCardRestClient() {
	}

	@Override
	public void updateCardToBuy(TransactionCardDTO transactionCardDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION_BUY, transactionCardDTO, ResponseEntity.class);
	}
	
	@Override
	public void updateCardToSell(TransactionCardDTO transactionCardDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION_SELL, transactionCardDTO, ResponseEntity.class);
	}

}

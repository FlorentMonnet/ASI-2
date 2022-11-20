package microservice.user.rest.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionUserRestClient implements TransactionUserRest{
	
	private static final String URL_TRANSACTION = "http://reverse-proxy:80/api/transaction-microservice"; 
	private static final String URL_TRANSACTION_BUY = URL_TRANSACTION + "/buy-user-ok"; 
	private static final String URL_TRANSACTION_SELL = URL_TRANSACTION + "/sell-user-ok"; 
	
	public TransactionUserRestClient() {
	}

	@Override
	public void updateUserToBuy(TransactionUserDTO transactionUserDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION_BUY, transactionUserDTO, ResponseEntity.class);
	}
	
	@Override
	public void updateUserToSell(TransactionUserDTO transactionUserDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION_SELL, transactionUserDTO, ResponseEntity.class);
	}


}

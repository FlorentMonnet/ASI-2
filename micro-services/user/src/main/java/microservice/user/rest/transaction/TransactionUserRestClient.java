package microservice.user.rest.transaction;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TransactionUserRestClient implements TransactionUserRest{
	
	private static final String URL_TRANSACTION = "http://reverse-proxy:80/api/transaction-microservice"; 
	
	
	public TransactionUserRestClient() {
	}

	@Override
	public void updateUserToPay(TransactionUserDTO transactionUserDTO) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject(URL_TRANSACTION + "/user-ok", transactionUserDTO, ResponseEntity.class);
	}


}

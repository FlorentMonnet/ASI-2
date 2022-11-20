package microservice.transaction.dto;

import microservice.transaction.rest.user.UserDTO;

public class TransactionUserDTO {
	private Integer id_transaction_user;
	private UserDTO user;
	
	public TransactionUserDTO() {
		super();
	}

	public TransactionUserDTO(Integer id_transaction_card, UserDTO user) {
		super();
		this.id_transaction_user = id_transaction_card;
		this.user = user;
	}


	public Integer getId() {
		return id_transaction_user;
	}


	public void setId(Integer id_transaction_card) {
		this.id_transaction_user = id_transaction_card;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "TransactionCardDTO [id_transaction_user=" + id_transaction_user + ", user=" + user + "]";
	}
}

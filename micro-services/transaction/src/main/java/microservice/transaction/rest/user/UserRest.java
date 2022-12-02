package microservice.transaction.rest.user;

import java.util.Optional;

import microservice.transaction.dto.TransactionUserDTO;

public interface UserRest {
	public Optional<UserDTO> getUserById(Integer id_user);
	public void updateUser(UserDTO userDTO);
	public void updateUserToBuy(TransactionUserDTO transactionUserDTO);
	public void updateUserToSell(TransactionUserDTO transactionUserDTO);
}


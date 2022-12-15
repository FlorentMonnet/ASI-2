package microservice.common;

import java.util.Optional;



public interface UserRest {
	public Optional<UserDTO> getUserById(Integer id_user);
	public void updateUser(UserDTO userDTO);
	public void updateUserToBuy(TransactionUserDTO transactionUserDTO);
	public void updateUserToSell(TransactionUserDTO transactionUserDTO);
}


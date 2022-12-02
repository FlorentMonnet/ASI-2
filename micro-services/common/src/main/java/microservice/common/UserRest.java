package microservice.common;

import java.util.Optional;



public interface UserRest {
	public Optional<UserDTO> getUserById(Integer id_user);
	public void updateUser(UserDTO userDTO);
	public void updateUserToPay(TransactionUserDTO transactionUserDTO);
}


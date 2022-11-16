package microservice.transaction.rest.user;

import java.util.Optional;

public interface UserRest {
	public Optional<UserDTO> getUserById(Integer id_user);
	public void updateUser(UserDTO dto);
}


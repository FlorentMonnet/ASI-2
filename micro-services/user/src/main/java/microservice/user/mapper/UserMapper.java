package microservice.user.mapper;

import org.springframework.stereotype.Component;

import microservice.user.dto.UserDTO;
import microservice.user.entity.User;
@Component
public class UserMapper {
	
	public User toModel(UserDTO userDTO) {
		User toReturn = new User();
		
		
		toReturn.setIsAdmin(userDTO.getIsAdmin());
		toReturn.setMoney(userDTO.getMoney());
		toReturn.setName(userDTO.getName());
		toReturn.setSurname(userDTO.getSurname());
		toReturn.setMail(userDTO.getMail());
		toReturn.setId_user(userDTO.getId_user());
		
		return toReturn;
		
	}
	
	public UserDTO toDTO(User user) {
		UserDTO toReturn = new UserDTO();
		
		toReturn.setIsAdmin(user.getIsAdmin());
		toReturn.setMoney(user.getMoney());
		toReturn.setName(user.getName());
		toReturn.setSurname(user.getSurname());
		toReturn.setMail(user.getMail());
		toReturn.setId_user(user.getId_user());
		
		return toReturn;
		
	}
	
}

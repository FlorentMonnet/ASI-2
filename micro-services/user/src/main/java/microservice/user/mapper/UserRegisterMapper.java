package microservice.user.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import microservice.user.dto.UserLoginDTO;
import microservice.user.dto.UserRegisterDTO;
import microservice.user.entity.User;

@Component
public class UserRegisterMapper {
	public User toModel(UserRegisterDTO userRegisterDTO) {
		User user = new User();
		
		user.setIsAdmin(userRegisterDTO.getIsAdmin());
		user.setMoney(userRegisterDTO.getMoney());
		user.setName(userRegisterDTO.getName());
		user.setSurname(userRegisterDTO.getSurname());
		user.setMail(userRegisterDTO.getMail());
		user.setId_user(userRegisterDTO.getId_user());
		user.setPassword(userRegisterDTO.getPassword());
		
		return user;
		
	}
	
	public UserRegisterDTO toDTO(User user) {
		UserRegisterDTO userDTO = new UserRegisterDTO();
		
		userDTO.setIsAdmin(user.getIsAdmin());
		userDTO.setMoney(user.getMoney());
		userDTO.setName(user.getName());
		userDTO.setSurname(user.getSurname());
		userDTO.setMail(user.getMail());
		userDTO.setId_user(user.getId_user());
		userDTO.setPassword(user.getPassword());
		
		return userDTO;
	}
	
	public UserRegisterDTO toDTO(UserLoginDTO userLoginDTO) {
		UserRegisterDTO userDTO = new UserRegisterDTO();
		
		userDTO.setMail(userLoginDTO.getMail());
		userDTO.setPassword(userLoginDTO.getPassword());
		
		return userDTO;
	}
	
	public List<UserRegisterDTO> toDTOList(List<User> users) {
		List<UserRegisterDTO> usersRegisterDTOList=new ArrayList<UserRegisterDTO>();
		for(User user: users){
			usersRegisterDTOList.add(this.toDTO(user));
		}
		return usersRegisterDTOList;
	}
}

package microservice.authentication.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import microservice.authentication.dto.UserRegisterDTO;
import microservice.authentication.utils.JWTUtils;

@Service
public class AuthenticationService {
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

	public String createToken(UserRegisterDTO dto) {
        Map<String, Object> map = new HashMap<>();
		map.put("isAdmin", dto.getIsAdmin());
		String token = JWTUtils.createJWT(dto.getMail(), map);
		return token;
	}
	
	public String encryptPassword(UserRegisterDTO dto) {
        return bCryptPasswordEncoder.encode(dto.getPassword());
	}
	
	public boolean checkPassword(List<UserRegisterDTO> dtoUserFoundAndUserLogging) {
		if (dtoUserFoundAndUserLogging.size() != 2) { // TODO
			return false;
		}
		if(!bCryptPasswordEncoder.matches(dtoUserFoundAndUserLogging.get(1).getPassword(), dtoUserFoundAndUserLogging.get(0).getPassword())) {
			return false;
		}
		return true;
	}

}

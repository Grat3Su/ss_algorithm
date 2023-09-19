package regist.service;

import dto.UserDto;

public interface RegistService {
	UserDto join(String userID, String userPassword, String userName);
    UserDto joinout(String userID, String userPassword, String userName);
}

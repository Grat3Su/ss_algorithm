package regist.service;

import dto.UserDto;

public interface RegistService {
	UserDto join(String userID, String userName, String userPassword);
    UserDto joinout(String userID);
}

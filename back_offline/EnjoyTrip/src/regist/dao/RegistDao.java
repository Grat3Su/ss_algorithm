package regist.dao;

import dto.UserDto;

public interface RegistDao {
    UserDto join(String userID, String userName, String password);
    UserDto joinout(String userID);
}

package loginout.dao;

import dto.UserDto;

public interface LoginoutDao {
	// id만 체크해서 유저가 있는지를 확인하고 pw는 서비스에서 비교하겠다
	UserDto login(String userID);
}

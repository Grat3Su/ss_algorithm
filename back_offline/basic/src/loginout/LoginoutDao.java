package loginout;

import dto.UserDto;

public interface LoginoutDao {
	UserDto login(String userEmail);
	// 이메일만 체크해서 유저가 있는지를 확인하고 pw는 서비스에서 비교하겠다
}

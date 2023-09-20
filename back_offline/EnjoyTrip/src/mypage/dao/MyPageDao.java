package mypage.dao;

import dto.UserDto;

public interface MyPageDao {
	 UserDto change(String userID, String password);
}

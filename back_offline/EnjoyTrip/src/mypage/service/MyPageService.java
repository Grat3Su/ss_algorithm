package mypage.service;

import dto.UserDto;

public interface MyPageService {
	UserDto change(String userID, String userPassword);
}

package mypage.service;

import dto.UserDto;
import mypage.dao.MyPageDao;
import mypage.dao.MyPageDaoImpl;

public class MyPageServiceImpl implements MyPageService {
    private MyPageDao mypageDao = new MyPageDaoImpl();

	@Override
	public UserDto change(String userID, String userPassword) {
		UserDto userDto = mypageDao.change(userID, userPassword);
		if(userDto!=null) {
			userDto.setUserPsssword(null);
			System.out.println("비번 변경");
			return userDto;
		}
		System.out.println(userDto);
		return null;
		}

}

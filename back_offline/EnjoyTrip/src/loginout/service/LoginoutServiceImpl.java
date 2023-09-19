package loginout.service;

import dto.UserDto;
import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;

public class LoginoutServiceImpl implements LoginoutService{
private LoginoutDao loginoutDao = new LoginoutDaoImpl();

@Override
public UserDto login(String userID, String userPassword) {
	UserDto userDto = loginoutDao.login(userID);
	
	if(userDto!=null&&userDto.getUserPsssword().equals(userPassword)) {
		userDto.setUserPsssword(null);
		System.out.println("로그인");
		return userDto;
	}
	System.out.println(userDto);
	return null;//useremail이 올바르지 않거나 userpassword가 올바르지 않느 2가지 모두 포함
}

}

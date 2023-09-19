package main.service;

import dto.UserDto;
import loginout.LoginoutDao;
import loginout.LoginoutDaoImpl;

public class LoginoutServiceImpl implements LoginoutService{
private LoginoutDao loginoutDao = new LoginoutDaoImpl();

@Override
public UserDto login(String userEmail, String userPassword) {
	UserDto userDto = loginoutDao.login(userEmail);
	
	if(userDto!=null&&userDto.getUserPsssword().equals(userPassword)) {
		userDto.setUserPsssword(null);
		return userDto;
	}
	return null;//useremail이 올바르지 않거나 userpassword가 올바르지 않느 2가지 모두 포함
}

}

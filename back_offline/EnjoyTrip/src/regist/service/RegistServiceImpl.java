package regist.service;

import dto.UserDto;
import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;
import regist.dao.RegistDao;

public class RegistServiceImpl implements RegistService{
    private RegistDao registDao = new LoginoutDaoImpl();

    @Override
    public UserDto join(String userID, String userPassword, String userName) {
        UserDto userDto = registDao.join(userID,userName,userPassword);
	
	if(userDto==null) {
		userDto.setUserPsssword(null);
		System.out.println("회원가입");
		return userDto;
	}
	System.out.println(userDto);
	return null;//id 이미 있으면 가입 불가
}    

    @Override
    public UserDto joinout(String userID, String userPassword, String userName) {
        UserDto userDto = registDao.joinout(userID,userName,userPassword);
	
        if(userDto!=null&&userDto.getUserPsssword().equals(userPassword)) {
            System.out.println("탈퇴");
            return userDto;
        }
        return null;//탈퇴
    }

}

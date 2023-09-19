package dto;

public class UserDto {
	String userId;
	String userName;
	String userPsssword;
	public UserDto(String userId, String userName, String userPsssword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPsssword = userPsssword;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPsssword() {
		return userPsssword;
	}
	public void setUserPsssword(String userPsssword) {
		this.userPsssword = userPsssword;
	}
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userName=" + userName + ", userPsssword=" + userPsssword + "]";
	}


}


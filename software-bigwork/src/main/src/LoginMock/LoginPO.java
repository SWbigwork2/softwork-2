package LoginMock;

import UsersMock.UserInfo;
import UsersMock.UserType;

public class LoginPO {
	private String ID;
	private String password;
	private UserType usersType;
	private UserInfo info;
	public LoginPO(String iD, String password, UserType usersType, UserInfo info) {
		ID = iD;
		this.password = password;
		this.usersType = usersType;
		this.info = info;
	}
	
}

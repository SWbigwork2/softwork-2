package LoginMock;

import UsersMock.UserInfo;
import UsersMock.UserPO;
import UsersMock.UserType;
import UsersMock.Users;

public class MarketerLoginMock extends LoginMock{
	UserInfo use;
	public MarketerLoginMock(UserInfo u) {
		use = u;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResultMessage login(String id, String password) {
		String rightId = use.getId();
		String rightPass = use.getPassword();
		if(rightId==null||!use.getRole().equals(UserType.marketer)){
			return ResultMessage.userNotExit;
		}
		if(password.equals(rightPass)){
			return ResultMessage.success;
		}
		else{
			return ResultMessage.passwordError;
		}
		// TODO Auto-generated method stub
	
	}

	

	@Override
	public LoginPO getMessage(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

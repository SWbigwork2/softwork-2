package LoginMock;

import UsersMock.UserPO;
import UsersMock.UserType;
import UsersMock.Users;

public class MemberLoginMock extends LoginMock{
	Users use;
	public MemberLoginMock(Users u) {
		use = u;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ResultMessage login(String id, String password) {
		UserPO po = use.findUser(id,UserType.member);
		if(po==null){
			return ResultMessage.userNotExit;
		}
		if(po.getPassword().equals(password)){
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

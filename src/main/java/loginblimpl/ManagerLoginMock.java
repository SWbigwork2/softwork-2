package loginblimpl;

import UsersMock.UserInfo;
import UsersMock.UserType;
import UsersMock.UserVO;
import UsersMock.Users;
import po.LoginPO;

public class ManagerLoginMock extends LoginMock{
	UserVO vo;
	UserInfo use;
	public ManagerLoginMock(UserInfo u) {
		use = u;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LoginVo login(String id, String password) {
		vo = use.find(id, UserType.manager);
		String rightId = vo.getUserId();
		String rightPass =vo.getPassword();
		if(id.equals(rightId)&&password.equals(rightPass)){
			String level = vo.getLevel();
			String name = vo.getName();
			return new LoginVo(UserType.manager, id, name, level);
		}
		else{
			return null;
		}
		// TODO Auto-generated method stub
	
	}

	

	@Override
	public LoginPO getMessage(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}

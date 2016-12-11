package loginblimpl;

import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.Users;
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
		System.out.println(rightId);
		System.out.println(rightPass);
		System.out.println(id);
		System.out.println(password);
		if(id.equals(rightId)&&password.equals(rightPass)){
			String level = null;
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

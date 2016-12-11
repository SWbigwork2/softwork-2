package loginblimpl;

import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.Users;
import po.LoginPO;

public class MarketerLoginMock extends LoginMock{
	UserVO vo;
	UserInfo use;
	public MarketerLoginMock(UserInfo u) {
		use = u;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LoginVo login(String id, String password) {
		vo = use.find("1000", UserType.marketer);
	
		String rightId = vo.getUserId();
		String rightPass =vo.getPassword();
		if(id.equals(rightId)&&password.equals(rightPass)){
			String level = null;
			String name = vo.getName();
			return new LoginVo(UserType.marketer, id, name, level);
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

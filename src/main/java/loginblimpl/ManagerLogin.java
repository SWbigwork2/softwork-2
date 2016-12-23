package loginblimpl;

import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.Users;
import po.LoginPO;

/**
 * @author 朱润之
 * 网站管理人员登陆的子类
 */
public class ManagerLogin extends Login{
	UserVO vo;
	UserInfo use;
	public ManagerLogin(UserInfo u) {
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

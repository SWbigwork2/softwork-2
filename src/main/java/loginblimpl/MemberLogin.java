package loginblimpl;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.Users;
import po.LoginPO;

/**
 * @author 朱润之
 * 会员登录的子类
 */
public class MemberLogin extends Login{
	UserVO vo;
	UserInfo use;
	public MemberLogin(UserInfo u) {
		use = u;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public LoginVo login(String id, String password) {
		vo = use.find(id, UserType.member);
		String rightId = vo.getUserId();
		String rightPass =vo.getPassword();
		if(id.equals(rightId)&&password.equals(rightPass)){
			String level = ((MemberInformationVO) vo).getLevel();
			String name = vo.getName();
			return new LoginVo(UserType.member, id, name, level);
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

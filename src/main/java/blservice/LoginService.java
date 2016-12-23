package blservice;

import Usersblimpl.UserType;
import loginblimpl.LoginVo;


public interface LoginService {
	/**
	 * @param Id
	 * @param password
	 * @param type
	 * @return 登陆的方法
	 */
	public LoginVo login(String Id,String password,UserType type);

}

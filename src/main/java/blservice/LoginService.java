package blservice;

import Usersblimpl.UserType;
import loginblimpl.LoginVo;
import loginblimpl.ResultMessage;

public interface LoginService {
	public LoginVo login(String Id,String password,UserType type);

}

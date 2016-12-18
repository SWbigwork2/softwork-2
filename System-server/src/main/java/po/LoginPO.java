package po;

import java.io.Serializable;

import Usersblimpl.UserInfo;
import Usersblimpl.UserType;

public class LoginPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1443162645998603682L;
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

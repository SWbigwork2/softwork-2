package loginblimpl;

import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import Usersblimpl.Users;
import blservice.LoginService;

public class LoginControllerimpl implements LoginService{
	public  int []loginType = new int [4];
	private String []loginM = new String[4];
	private LoginMock login;
	UserInfo users;
	public LoginControllerimpl(){
		users = new UserControllerblimpl();
		// TODO Auto-generated constructor stub
	}
	public void logout(UserType type){
		loginType[type.ordinal()]=0;
	}
	public LoginVo login(String Id,String password,UserType type){
		if(type==UserType.member){
			login = new MemberLoginMock(users);
		}
		else if(type==UserType.manager){
			login=new ManagerLoginMock(users);
		}
		else if(type==UserType.marketer){
			login=new MarketerLoginMock(users);
		}
		else if(type==UserType.staff){
			login=new StaffLoginMock(users);
		}
		LoginVo resultVo =login.login(Id, password);
		
		return resultVo; 
	}
	public String getMessage(UserType type){
		return loginM[type.ordinal()];
	}
}

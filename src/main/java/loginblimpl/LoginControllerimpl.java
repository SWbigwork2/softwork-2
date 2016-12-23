package loginblimpl;

import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserInfo;
import Usersblimpl.UserType;
import blservice.LoginService;

/**
 * @author 朱润之
 * 登陆的控制器，根据不同的type创建不同的login对象
 */
public class LoginControllerimpl implements LoginService{
	public  int []loginType = new int [4];
	private String []loginM = new String[4];
	private Login login;
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
			login = new MemberLogin(users);
		}
		else if(type==UserType.manager){
			login=new ManagerLogin(users);
		}
		else if(type==UserType.marketer){
			login=new MarketerLogin(users);
		}
		else if(type==UserType.staff){
			login=new StaffLogin(users);
		}
		LoginVo resultVo =login.login(Id, password);
		
		return resultVo; 
	}
	public String getMessage(UserType type){
		return loginM[type.ordinal()];
	}
}

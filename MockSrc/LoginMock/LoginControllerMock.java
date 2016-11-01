package LoginMock;

import UsersMock.UserType;
import UsersMock.Users;

public class LoginControllerMock {
	public  int []loginType = new int [4];
	private String []loginM = new String[4];
	private LoginMock login;
	Users users;
	public LoginControllerMock() {
		users = new Users();
		// TODO Auto-generated constructor stub
	}
	public void logout(UserType type){
		loginType[type.ordinal()]=0;
	}
	public ResultMessage login(String Id,String password,UserType type){
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
		int i=type.ordinal();
		loginM[i]=Id;
		loginType[i]=1;
		return login.login(Id, password);
	}
	public String getMessage(UserType type){
		return loginM[type.ordinal()];
	}
}

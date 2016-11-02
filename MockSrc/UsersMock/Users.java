package UsersMock;

public class Users {
	public UserPO findUser(String id,UserType type){
		return new UserPO("1", "admin", "admin", UserType.member, null);
	}


}

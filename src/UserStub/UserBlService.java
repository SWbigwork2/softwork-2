package UserStub;



public interface UserBlService {
	public ResultMessage add(int i, String string, String string2, UserType staff, String string3);

	public UserVO find(int i, UserType staff);

	public ResultMessage revamp(int i, UserType staff);

	public ResultMessage login(int userId,String name,String password,UserType user);

}

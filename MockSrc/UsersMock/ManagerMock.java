package UsersMock;

public class ManagerMock extends UserMock{

	@Override
	public UserVO find(String id, UserType type) {
		
		return null;
	}

	@Override
	public ResultMessage revoke(String  id, UserVO user, UserType type) {
		return null;
	}
	
}

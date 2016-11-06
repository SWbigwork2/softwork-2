package UsersMock;

public class ManagerMock extends UserMock{

	@Override
	public UserVO find(int id, UserType type) {
		
		return null;
	}

	@Override
	public ResultMessage revoke(int id, UserVO user, UserType type) {
		return null;
	}
	
}

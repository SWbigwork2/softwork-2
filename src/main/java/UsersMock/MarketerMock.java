package UsersMock;

public class MarketerMock extends UserMock{

	@Override
	public UserVO find(String id, UserType type) {
		
		return new MarketerVO("1113","123456","xiaolan");
	}

	@Override
	public ResultMessage revoke(UserVO user) {
		ResultMessage resultMessage=null;
		return resultMessage;
	}

	
	
}

package UsersMock;

public class MarketerMock extends UserMock{

	@Override
	public UserVO find(String id, UserType type) {
		
		return new MarketerVO("1113","123456","xiaolan");
	}

	@Override
	public ResultMessage revoke(String id, UserVO user, UserType type) {
		if(user.userId!=id||!type.equals(UserType.marketer)){
			return ResultMessage.fail;
		}else{
			return ResultMessage.success;
		}
	}

	
	
}

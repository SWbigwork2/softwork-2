package UsersMock;


public class StaffMock extends UserMock {

	@Override
	public UserVO find(String id, UserType type) {
		
		return new StaffVO("1112","1234567","xiaohong","如家");
	}

	@Override
	public ResultMessage revoke(String id, UserVO user, UserType type) {
		// TODO Auto-generated method stub
		if(!user.userId.equals(id)||!type.equals(UserType.staff)){
			return ResultMessage.fail;
		}else{
			return ResultMessage.success;
		}
	}
    
	public ResultMessage add(HotelInfo hotel,StaffVO staff){
		return ResultMessage.success;
	}

	
}

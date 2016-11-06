package UsersMock;


public class StaffMock extends UserMock {

	@Override
	public UserVO find(int id, UserType type) {
		
		return new StaffVO(1112,"1234567","xiaohong","ИзјТ");
	}

	@Override
	public ResultMessage revoke(int id, UserVO user, UserType type) {
		// TODO Auto-generated method stub
		if(user.userId!=id||!type.equals(UserType.staff)){
			return ResultMessage.fail;
		}else{
			return ResultMessage.success;
		}
	}
    
	public ResultMessage add(HotelInfo hotel,StaffVO staff){
		return ResultMessage.success;
	}

	
}

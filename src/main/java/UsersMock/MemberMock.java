package UsersMock;

public class MemberMock extends UserMock {

	@Override
	public UserVO find(String id, UserType type) {
		return new MemberVO("1111","1234567","xiaoming");
	}

	@Override
	public ResultMessage revoke(String id, UserVO user, UserType type) {
		if(user.userId.equals(id)){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
		
	}
	
	public ResultMessage register(MemberVO member){
		UserPO newMember=new UserPO(member.userId,member.password,null,UserType.member,member.name,member.birthday);
		return ResultMessage.success;	
	}
	
	

}

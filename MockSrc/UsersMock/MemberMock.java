package UsersMock;

public class MemberMock extends UserMock {

	@Override
	public UserVO find(int id, UserType type) {
		return new MemberVO(1111,"1234567","xiaoming");
	}

	@Override
	public ResultMessage revoke(int id, UserVO user, UserType type) {
		if(user.userId==id){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
		
	}
	
	public ResultMessage register(MemberVO member){
		UserPO newMember=new UserPO(Integer.toString(member.userId),member.password,null,UserType.member,member.name);
		return ResultMessage.success;	
	}
	
	

}

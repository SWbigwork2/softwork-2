package Usersblimpl;

public class MarketerVO extends UserVO {
	 
	public MarketerVO(String id,String password,String name){
		    super(id, name, password, UserType.marketer.name());
	}
}

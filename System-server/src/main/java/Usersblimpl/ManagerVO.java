package Usersblimpl;

public class ManagerVO extends UserVO{
	
    public ManagerVO(String userId,String name,String password){
    	super(userId, name, password, UserType.manager.name());
    }
    
}

package UsersMock;

public class MarketerVO extends UserVO {
	 public MarketerVO(int id,String password,String name){
	    	this.userId=id;
	    	this.password=password;
	    	this.name=name;
	    	this.type=UserType.marketer;
	    }
}

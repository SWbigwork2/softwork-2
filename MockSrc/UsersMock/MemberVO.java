package UsersMock;

public class MemberVO extends UserVO{
	
	 public MemberVO(int id,String password,String name){
	    	this.userId=id;
	    	this.password=password;
	    	this.name=name;
	    	this.type=UserType.member;
    }
	 public int getId(){
		 return this.userId;
	 }
	 
	 public String getPassword(){
		 return this.password;
	 }
	 public String getName(){
		 return this.name;
	 }
}

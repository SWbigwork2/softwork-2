package UsersMock;

import java.util.Date;

public class MemberVO extends UserVO{
	 Date birthday;
	 public MemberVO(String id,String password,String name){
	    	this.userId=id;
	    	this.password=password;
	    	this.name=name;
	    	this.type=UserType.member;
	 }
	 public String getId(){
		 return this.userId;
	 }
	 public String getPassword(){
		 return this.password;
	 }
	 public String getName(){
		 return this.name;
	 }
	 public UserType getType(){
		 return UserType.member;
	 }
	 
	 
}


package po;

import java.util.Date;

import UsersMock.UserInfo;
import UsersMock.UserType;

public class UserPO implements UserInfo{
	String id;
	String name;
    String password;
//    String hotel;
    UserType role;
//    Date birthday;
    public UserPO(String i,String n,String p ,UserType r){
    	this.id=i;
    	this.name=n;
    	this.password=p;
    	this.role=r;
//    	this.hotel=hotel;
//    	this.birthday=birthday;
    }
    
    public String getId() {
		return id;
	}
    public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public UserType getRole() {
		return this.role;
	}

	public String getHotel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

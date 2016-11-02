package UsersMock;



public class UserPO implements UserInfo{
	String id;
	String name;
    String password;
    String hotel;
    UserType role;
    
    public UserPO(String i,String n,String p ,UserType r,String hotel){
    	this.id=i;
    	this.name=n;
    	this.password=p;
    	this.role=r;
    	this.hotel=hotel;
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
	
	public String getHotel(){
		return this.hotel;
	}
}

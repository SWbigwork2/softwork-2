package UsersMock;

public class StaffVO extends UserVO{
    String hotelName;
    
    public StaffVO(String id,String password,String name,String hotelName){
    	this.userId=id;
    	this.password=password;
    	this.name=name;
    	this.type=UserType.staff;
    	this.hotelName=hotelName;
    }
}

package UsersMock;

public class StaffVO extends UserVO{
    String hotelName;
    
   

	public StaffVO(String id,String password,String name,String hotelName){
    	super(id, name, password, UserType.staff);
    	this.hotelName=hotelName;
    }
    
	
	public String getHotelName() {
		return hotelName;
	}
    
}

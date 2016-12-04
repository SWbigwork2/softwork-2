package Usersblimpl;

public class StaffVO extends UserVO{
   
	private String hotelName;
    
   

	public StaffVO(String id,String password,String name,String hotelName){
    	super(id, name, password, UserType.staff.name());
    	this.hotelName=hotelName;
    }
    
	
	public String getHotelName() {
		return hotelName;
	}
   
	
	 public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}


}

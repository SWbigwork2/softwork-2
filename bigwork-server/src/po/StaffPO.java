package po;

import UserServerAssist.UserType;

public class StaffPO extends UserPO{
	String  hotelName;
	
	public StaffPO(String staffId, String staffName, String password, String hotelName) {
		super(staffId, staffName, password, UserType.staff);
        this.hotelName=hotelName;		
	}

	public String getHotelName(){
		return this.hotelName;
	}

}

package po;

import Usersblimpl.UserType;

public class StaffPO extends UserPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 765099796507911538L;
	String  hotelName;
	
	public StaffPO(String staffId, String staffName, String password, String hotelName) {
		super(staffId, staffName, password, UserType.staff);
        this.hotelName=hotelName;		
	}

	public String getHotelName(){
		return this.hotelName;
	}

}

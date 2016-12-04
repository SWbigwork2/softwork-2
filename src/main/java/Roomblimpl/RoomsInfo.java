package Roomblimpl;

import java.sql.Timestamp;
import java.util.ArrayList;

public interface RoomsInfo {
	public String getRoomName();
	public String getHotelBelongTo();
	public RoomType getRoomType();
	public String getIntroduction();
	public double getPrice();
	public ArrayList<Timestamp> getRoomStatus();
}

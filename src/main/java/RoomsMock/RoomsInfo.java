package RoomsMock;

import java.sql.Date;
import java.util.ArrayList;

public interface RoomsInfo {
	public String getRoomName();
	public String getHotelBelongTo();
	public RoomType getRoomType();
	public String getIntroduction();
	public double getPrice();
	public ArrayList<Date> getRoomStatus();
}

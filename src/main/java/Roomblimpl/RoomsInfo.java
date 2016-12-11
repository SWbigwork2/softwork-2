package Roomblimpl;

import java.sql.Date;
import java.util.Map;

public interface RoomsInfo {
	public String getRoomName();
	public String getHotelBelongTo();
	public RoomType getRoomType();
	public String getIntroduction();
	public double getPrice();
	public Map<Date,Date> getUnavailablePeriod();
}

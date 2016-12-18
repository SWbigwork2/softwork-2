package Roomblimpl;

import java.util.Date;
import java.util.Map;

public interface RoomsInfo {
	public int getId();
	public String getHotelBelongTo();
	public RoomType getRoomType();
	public String getIntroduction();
	public double getPrice();
	public Map<Date,Date> getUnavailablePeriod();
}

package HotelStub;

import java.util.*;

public interface HotelBLService {
	public ArrayList <HotelVO> searchHotel(HotelVO h);
	public OrderVO getHistoryOrder();
	public HotelVO browseHotelDetail(String name);
	public ResultMessage evaluateHotel(String evaluation,String HotelName);
	public ResultMessage updateInfo(HotelVO h);
	public ResultMessage addHotel(HotelVO h);
}

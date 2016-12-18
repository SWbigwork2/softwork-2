package po;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import Roomblimpl.RoomType;
import Roomblimpl.RoomsInfo;
public class RoomPO implements Serializable,RoomsInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3336011436313431937L;
	private int roomId;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	private Map<Date, Date> unavailablePeriod;
	
	
	public RoomPO(int roomId, String hotelBelongTo, RoomType roomtype,String introdution,double price, Map<Date, Date> unavailablePeriod){
		this.roomId= roomId;
		this.hotelBelongTo =hotelBelongTo;
		this.roomtype =roomtype;
		this.introdution=introdution;
		this.price =price;
		this.unavailablePeriod =unavailablePeriod;
	}
	
	public int getId(){
		return roomId;	
	}
	public String getHotelBelongTo(){
		return hotelBelongTo;
	}
	public RoomType getRoomType(){
		return roomtype;
	}
	public String getIntroduction(){
		return introdution;
	}
	public double getPrice(){
		return price;
	}
	public Map<Date, Date> getUnavailablePeriod() {
		return unavailablePeriod;
	}
}

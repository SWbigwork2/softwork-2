package po;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import Roomblimpl.RoomType;
import Roomblimpl.RoomsInfo;




public class RoomPO implements Serializable,RoomsInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -438235272461601501L;
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	private Map<Date, Date> unavailablePeriod;
	
	
	public RoomPO(String r, String h, RoomType t,String i,double p, Map<Date, Date> dateList){
		this.roomName= r;
		this.hotelBelongTo =h;
		this.roomtype =t;
		this.introdution=i;
		this.price =p;
		this.unavailablePeriod =dateList;
	}
	
	public String getRoomName(){
		return roomName;	
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

	public ArrayList<Timestamp> getRoomStatus() {
		// TODO Auto-generated method stub
		return null;
	}	
}

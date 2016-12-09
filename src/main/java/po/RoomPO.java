package po;
import java.io.Serializable;
import java.sql.Timestamp;
import Roomblimpl.RoomType;
import Roomblimpl.RoomsInfo;




public class RoomPO implements Serializable,RoomsInfo{
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	private Timestamp startTime;
	private Timestamp endTime;
	
	
	public RoomPO(String roomName, String hotelBelongTo, RoomType roomType,String introduction,double price,Timestamp startTime,Timestamp endTime){
		this.roomName= roomName;
		this.hotelBelongTo =hotelBelongTo;
		this.roomtype =roomType;
		this.introdution=introduction;
		this.price =price;
		this.startTime = startTime;
		this.endTime = endTime;
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
	public Timestamp getStartTime(){
		return startTime;
	}
	public Timestamp getEndTime(){
		return endTime;
	}
}

package RoomsMock;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

public class RoomPO implements Serializable,RoomsInfo{
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	ArrayList <Date> unavailablePeriod;
	
	
	public RoomPO(String roomName, String hotelBelongTo, RoomType roomType,String introduction,double price, ArrayList <Date> unavailablePeriod){
		this.roomName= roomName;
		this.hotelBelongTo =hotelBelongTo;
		this.roomtype =roomType;
		this.introdution=introduction;
		this.price =price;
		this.unavailablePeriod =unavailablePeriod;
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
	public ArrayList <Date> getRoomStatus(){
		return unavailablePeriod;
	}
	
}

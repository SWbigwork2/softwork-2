package po;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;




public class RoomPO implements Serializable,RoomsInfo{
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	private ArrayList<Timestamp>  unavailablePeriod;
	
	
	public RoomPO(String r, String h, RoomType t,String i,double p, ArrayList<Timestamp> dateList){
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
	public ArrayList <Timestamp> getRoomStatus(){
		return unavailablePeriod;
	}

	public void setPeriod(ArrayList<Timestamp> newTimeList) {
		unavailablePeriod = newTimeList;
	}
	
}

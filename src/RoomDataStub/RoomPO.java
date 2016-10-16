package RoomDataStub;
import java.io.Serializable;
import RoomStub.RoomType;
 

public class RoomPO implements Serializable{
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	//status需要存储不可用的时间段，不应采用int数组，具体实现待讨论
	private int[] unavailablePeriod;
	
	
	public RoomPO(String r, String h, RoomType t,String i,double p, int[] s){
		this.roomName= r;
		this.hotelBelongTo =h;
		this.roomtype =t;
		this.introdution=i;
		this.price =p;
		this.unavailablePeriod =s;
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
	public int[] getRoomStatus(){
		return unavailablePeriod;
	}
	
}

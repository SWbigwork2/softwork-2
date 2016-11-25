package po;
import java.io.Serializable;

import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;




public class RoomPO implements Serializable,RoomsInfo{
	private String roomName;
	private String hotelBelongTo;
	private RoomType roomtype;
	private String introdution;
	private double price;
	//status��Ҫ�洢�����õ�ʱ��Σ���Ӧ����int���飬����ʵ�ִ�����
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

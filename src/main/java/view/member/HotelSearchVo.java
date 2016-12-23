package view.member;

import java.time.LocalDate;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import Roomblimpl.RoomType;

public class HotelSearchVo {
	private String hotelName;
	private String hotelAddress;
	private LocalDate inTime;
	private LocalDate outTime;
	private RoomType roomType;
	private HotelTradeArea tradeArea;
	private double highPrice;
	private double lowPrice;
	private boolean isHistorySearch;
	private String memberId;
	private HotelRanking hotelRanking;
	private int numOfNeededRooms;
	private double highRemark;
	private double lowReamark;
	

	public HotelSearchVo(String hotelName, String hotelAddress, LocalDate inTime, LocalDate outTime, RoomType roomType,
			HotelTradeArea tradeArea, double highPrice, double lowPrice, boolean isHistorySearch,String memberId,HotelRanking hotelRanking,int numOfNeededRooms
			,double highRemark, double lowRemark) {
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.inTime = inTime;
		this.outTime = outTime;
		this.roomType = roomType;
		this.tradeArea = tradeArea;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.isHistorySearch = isHistorySearch;
		this.memberId = memberId;
		this.hotelRanking = hotelRanking;
		this.numOfNeededRooms = numOfNeededRooms;
		this.highRemark = highRemark;
		this.lowReamark = lowRemark;
	}
	
	public String getHotelName(){
		return hotelName;
	}
	
	public String getHotelAddress(){
		return hotelAddress;
	}
	public LocalDate getInTime(){
		return inTime;
	}
	public LocalDate getOutTime(){
		return outTime;
	}
	public RoomType getRoomType(){
		return roomType;
	}
	public HotelTradeArea getTradeArea(){
		return tradeArea;
	}
	public double getHighPrice(){
		return highPrice;
	}
	public double getLowPrice(){
		return lowPrice;
	}
	public boolean getIsHistorySearch(){
		return isHistorySearch;
	}
	public String memberId(){
		return memberId;
	}
	public HotelRanking getHotelRanking(){
		return hotelRanking;
	}
	public int getNumOfNeededRooms(){
		return numOfNeededRooms;
	}
	
	public double getHighRemark(){
		return highRemark;
	}
	
	public double getLowRemark(){
		return lowReamark;
	}
	
}

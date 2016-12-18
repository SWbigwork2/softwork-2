package view.member;

import Roomblimpl.RoomType;

public class RoomVo {

	private int roomId;
	private String hotelBelongTo;
	private RoomType roomType;
	private String roomIntroduction;
	private double roomPrice;

	public RoomVo(int roomId, String hotelBelongTo, RoomType roomType, String roomIntroduction, double roomPrice
			) {
		this.roomId = roomId;
		this.hotelBelongTo = hotelBelongTo;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.roomIntroduction = roomIntroduction;
		

	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getHotelBelongTo() {
		return hotelBelongTo;
	}

	public void setHotelBelongTo(String hotelBelongTo) {
		this.hotelBelongTo = hotelBelongTo;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public String getIntroduction() {
		return roomIntroduction;
	}

	public void setIntroduction(String roomIntroduction) {
		this.roomIntroduction = roomIntroduction;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

}

package view.member;

import java.util.Date;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class OrderVo {
	private String userLevel;
	private int orderId;
	private String userId;
	private String name;
	private String hotel;
	private Date beginDate;
	private Date completeDate;
	private Date inDate;
	private Date outDate;
	private Date deadLine;
	private double price;
	private String type;
	private String roomType;
	private int roomNum;
	private int peopleNum;
	private boolean hasChild;
	
	public String getRoomType() {
		return roomType;
	}

	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getRoomNum() {
		return roomNum;
	}

	public void setRoomNum(int roomNum) {
		this.roomNum = roomNum;
	}

	public int getPeopleNum() {
		return peopleNum;
	}

	public void setPeopleNum(int peopleNum) {
		this.peopleNum = peopleNum;
	}

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	public void setCompleteDate(Date completeDate) {
		this.completeDate = completeDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getCompleteDate() {
		return completeDate;
	}

	public void setCompelete(Date completeDate) {
		this.completeDate = completeDate;
	}

	public Date getInDate() {
		return inDate;
	}

	public void setInDate(Date inDate) {
		this.inDate = inDate;
	}

	public Date getOutDate() {
		return outDate;
	}

	public void setOutDate(Date outDate) {
		this.outDate = outDate;
	}

	public Date getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(Date deadLine) {
		this.deadLine = deadLine;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public String getUserLevel(){
		return userLevel;
	}
	public OrderVo() {
		// TODO Auto-generated constructor stub
	}
	public OrderVo(String userLevel, int orderId, String userId, String name, String hotel, Date beginDate,
			Date completeDate, Date inDate, Date outDate, Date deadLine, double price, String type, String roomType,
			int roomNum, int peopleNum, boolean hasChild) {
		this.userLevel = userLevel;
		this.orderId = orderId;
		this.userId = userId;
		this.name = name;
		this.hotel = hotel;
		this.beginDate = beginDate;
		this.completeDate = completeDate;
		this.inDate = inDate;
		this.outDate = outDate;
		this.deadLine = deadLine;
		this.price = price;
		this.type = type;
		this.roomType = roomType;
		this.roomNum = roomNum;
		this.peopleNum = peopleNum;
		this.hasChild = hasChild;
	}
	
}

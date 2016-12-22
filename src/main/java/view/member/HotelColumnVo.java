package view.member;


import Hotelblimpl.HotelRanking;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class HotelColumnVo {
	
	private String hotelName;
	private double hotelPrice;
	private HotelRanking hotelRanking;
	private double hotelRemark;
	
	public HotelColumnVo (String hotelName,double hotelPrice,HotelRanking hotelRanking,double hotelRemark){
		this.hotelName = hotelName;
		this.hotelPrice = hotelPrice;
		this.hotelRanking = hotelRanking;
		this.hotelRemark = hotelRemark;
	}
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	public void setHotelPrice(double hotelPrice){
		this.hotelPrice = hotelPrice;
	}
	public void setHotelRanking(HotelRanking hotelRanking){
		this.hotelRanking = hotelRanking;
	}
	public void setHotelRemark(double hotelRemark){
		this.hotelRemark = hotelRemark;
	}

	public StringProperty getHotelName(){
		return new SimpleStringProperty(hotelName);
	}
	public StringProperty getHotelPrice(){
		return new SimpleStringProperty(String.valueOf(hotelPrice));
	}
	public StringProperty getHotelRanking(){
		return new SimpleStringProperty(String.valueOf(hotelRanking));
	}
	public StringProperty getHotelRemark(){
		return new SimpleStringProperty(String.valueOf(hotelRemark).substring(0,3));
	}
}

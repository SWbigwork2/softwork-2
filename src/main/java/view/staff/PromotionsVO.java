package view.staff;

public class PromotionsVO {

	public int type;
	 public String hotel;
	 public double discount;
	 public String introduction;
	public int getType(){
		return type;
	}
	public void setType(int type){
		this.type=type;
	}
	public String getHotel(){
		return hotel;
	}
	public void setHotel(String hotel){
		this.hotel=hotel;
	}
	public double getDiscount(){
		return discount;
	}
	public void setDiscount(double discount){
		this.discount=discount;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	
}

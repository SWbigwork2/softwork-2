package po;

import java.io.Serializable;

public class PromotionsPO implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = -954887827818674317L;
public int type;
 public String hotel;
 public double discount;
 public String introduction;
public int getType(){
	return type;
}
public String getHotel(){
	return hotel;
}
public double getDiscount(){
	return discount;
}
public String getIntroduction(){
	return introduction;
}
public void setType(int type) {
	this.type = type;
}
public void setHotel(String hotel) {
	this.hotel = hotel;
}
public void setDiscount(double discount) {
	this.discount = discount;
}
public void setIntroduction(String introduction) {
	this.introduction = introduction;
}

}

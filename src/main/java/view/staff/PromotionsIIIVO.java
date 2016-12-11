package view.staff;

public class PromotionsIIIVO extends PromotionsVO{
	 int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	 public PromotionsIIIVO(int type,String hotel,String introduction,int num,double discount){
		     this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    	this.num=num;
	    }
}

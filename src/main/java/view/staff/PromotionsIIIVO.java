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
	       super(type, hotel, introduction, discount);
	    	this.num=num;
	    }
}

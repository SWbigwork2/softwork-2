package view.marketer;

import view.staff.PromotionsVO;

public class PromotionsVIVO extends PromotionsVO{
	 int viplevel;

	public int getViplevel() {
		return viplevel;
	}

	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}
	public PromotionsVIVO(int type,String hotel,String introduction,int viplevel,double discount){
		this.type=type;
    	this.hotel=hotel;
    	this.introduction=introduction;
    	this.discount=discount;
    	this.viplevel=viplevel;
    }
}

package view.marketer;

import view.staff.PromotionsVO;

public class PromotionsVVO extends PromotionsVO {
	int viplevel;
    String area;
	public int getViplevel() {
		return viplevel;
	}
	public void setViplevel(int viplevel) {
		this.viplevel = viplevel;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public PromotionsVVO(int type,String hotel,String introduction,int viplevel,String area,double discount){
    	super(type, hotel, introduction, discount);
    	this.area=area;
    	this.viplevel=viplevel;
    	
    }
}

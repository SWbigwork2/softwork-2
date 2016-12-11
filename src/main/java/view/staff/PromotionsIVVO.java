package view.staff;

public class PromotionsIVVO extends PromotionsVO{
	String companyname;

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	 public PromotionsIVVO(int type,String hotel,String introduction,String companyname,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    	this.companyname=companyname;
	    }
}

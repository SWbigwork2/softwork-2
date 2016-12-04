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
	    	super(type, hotel, introduction, discount);
	    	this.companyname=companyname;
	    }
}

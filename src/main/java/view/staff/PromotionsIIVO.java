package view.staff;

import java.util.Date;

public class PromotionsIIVO extends PromotionsVO{
	  Date startdate,enddate;

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getEnddate() {
		return enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	 public PromotionsIIVO(int type,String hotel,String introduction,Date startdate,Date enddate,double discount){
	    	super(type, hotel, introduction, discount);	   
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	
	    }
}

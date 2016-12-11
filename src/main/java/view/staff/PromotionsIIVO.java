package view.staff;

import java.util.Date;

/**
 * @author admin
 *
 */
public class PromotionsIIVO extends PromotionsVO{
	  String startdate,enddate;

	
	 public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public PromotionsIIVO(int type,String hotel,String introduction,String startdate,String enddate,double discount){
	    	super(type, hotel, introduction, discount);	   
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	
	    }
}

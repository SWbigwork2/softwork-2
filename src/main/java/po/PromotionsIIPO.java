package po;

import java.util.Date;

public class PromotionsIIPO extends PromotionsPO{	   
	    Date startdate,enddate;
	    public Date getStartdate(){
	    	return startdate;
	    }
	    public Date getEnddate(){
	    	return enddate;
	    }
	    public PromotionsIIPO(int type,String hotel,String introduction,Date startdate,Date enddate,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    }
	
}

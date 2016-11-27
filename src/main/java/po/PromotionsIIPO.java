package po;

import java.util.Date;

public class PromotionsIIPO extends PromotionsPO{
	    int  type;
	    String hotel;
	    Date startdate,enddate;
	    String introduction;
	    double discount;
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

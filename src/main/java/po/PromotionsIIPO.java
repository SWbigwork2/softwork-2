package po;

public class PromotionsIIPO extends PromotionsPO{	   
	    String startdate,enddate;
	    public String getStartdate(){
	    	return startdate;
	    }
	    public String getEnddate(){
	    	return enddate;
	    }
	    public PromotionsIIPO(int type,String hotel,String introduction,String startdate,String enddate,double discount){
	    	super(type, hotel, introduction, discount);
	    	
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	
	    }
	
}

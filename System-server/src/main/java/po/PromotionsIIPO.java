package po;

public class PromotionsIIPO extends PromotionsPO{	   
	    /**
	 * 
	 */
	private static final long serialVersionUID = 349117774427331005L;
		String startdate,enddate;
	    public String getStartdate(){
	    	return startdate;
	    }
	    public String getEnddate(){
	    	return enddate;
	    }
	    public PromotionsIIPO(int type,String hotel,String introduction,String startdate,String enddate,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    	
	    	this.startdate=startdate;
	    	this.enddate=enddate;
	    	
	    }
	
}

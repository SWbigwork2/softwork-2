package po;



public class PromotionsIVPO extends PromotionsPO{
	   /**
	 * 
	 */
	private static final long serialVersionUID = -3711295438046073078L;
	String companyname;
	   public String getcompanyname(){
		   return companyname;
	   }
	    public PromotionsIVPO(int type,String hotel,String introduction,String companyname,double discount){
	    	this.type=type;
	    	this.hotel=hotel;
	    	this.introduction=introduction;
	    	this.discount=discount;
	    	this.companyname=companyname;
	    }
	  
}

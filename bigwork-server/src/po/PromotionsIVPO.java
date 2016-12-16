package po;



public class PromotionsIVPO extends PromotionsPO{
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

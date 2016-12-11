package po;



public class PromotionsIVPO extends PromotionsPO{
	   String companyname;
	   public String getcompanyname(){
		   return companyname;
	   }
	    public PromotionsIVPO(int type,String hotel,String introduction,String companyname,double discount){
	    	super(type, hotel, introduction, discount);
	    	this.companyname=companyname;
	    }
	  
}

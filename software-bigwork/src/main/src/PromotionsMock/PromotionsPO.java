package PromotionsMock;


public class PromotionsPO {
	   String  hotel;
	   String type;
	   String role;
	 
	  public   PromotionsPO(String role,String hotel,String type ){
	  	    this.hotel=hotel;
	  	    this.type=type;
	  	    this.role=role;
	    }
	  public String getHotel(){
	  	   return hotel;
	     }
		 public  String getType(){
			 return type;
		 }
		  
		  public String getRole(){
			  return role;
		  }
		 
}
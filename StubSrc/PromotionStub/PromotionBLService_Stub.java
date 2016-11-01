package PromotionStub;


public class PromotionBLService_Stub implements PromotionBLService {
          Hotel hotel;
          String type;
          PromotionRole role;
          public  PromotionBLService_Stub(PromotionRole role,Hotel hotel,String type){
         	this.role=role;
         	this.hotel=hotel;
         	this.type=type;
          }
          //得到促销信息
          public PromotionVO getPromotion(){
         	 return new PromotionVO(role,hotel,type);
          }
          //执行策略制定
          public ResultMessage addStrategies(PromotionRole role,Hotel hotel,String type){
        	  if(role==PromotionRole.webworker&&hotel==Hotel.如家&&type=="1"){
        		     return ResultMessage.Failure;
        	  }else if(role==PromotionRole.webworker&&hotel==Hotel.如家&&type=="2"){
     		     return ResultMessage.Success;
     	  }else if(role==PromotionRole.webworker&&hotel==Hotel.如家&&type=="3"){
 		     return ResultMessage.Success;
 	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.如家&&type=="1"){
		     return ResultMessage.Success;
	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.如家&&type=="2"){
		     return ResultMessage.Success;
	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.如家&&type=="3"){
		     return ResultMessage.Success;
	  }else {return ResultMessage.Failure;
	  
	  }
          }
        public ResultMessage deleteStragies(PromotionRole role,Hotel hotel,String type){
        	 if(role==PromotionRole.webworker&&hotel==Hotel.如家&&type=="1"){
    		     return ResultMessage.Success;
  }else {return ResultMessage.Failure;
  
  }
        }
}

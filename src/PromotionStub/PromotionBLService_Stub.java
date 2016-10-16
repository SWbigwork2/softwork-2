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
          //�õ�������Ϣ
          public PromotionVO getPromotion(){
         	 return new PromotionVO(role,hotel,type);
          }
          //ִ�в����ƶ�
          public ResultMessage addStrategies(PromotionRole role,Hotel hotel,String type){
        	  if(role==PromotionRole.webworker&&hotel==Hotel.���&&type=="1"){
        		     return ResultMessage.Failure;
        	  }else if(role==PromotionRole.webworker&&hotel==Hotel.���&&type=="2"){
     		     return ResultMessage.Success;
     	  }else if(role==PromotionRole.webworker&&hotel==Hotel.���&&type=="3"){
 		     return ResultMessage.Success;
 	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.���&&type=="1"){
		     return ResultMessage.Success;
	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.���&&type=="2"){
		     return ResultMessage.Success;
	  }else if(role==PromotionRole.hotelworker&&hotel==Hotel.���&&type=="3"){
		     return ResultMessage.Success;
	  }else {return ResultMessage.Failure;
	  
	  }
          }
        public ResultMessage deleteStragies(PromotionRole role,Hotel hotel,String type){
        	 if(role==PromotionRole.webworker&&hotel==Hotel.���&&type=="1"){
    		     return ResultMessage.Success;
  }else {return ResultMessage.Failure;
  
  }
        }
}

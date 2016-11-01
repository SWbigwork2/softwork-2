package RoomStub;

import OrderStub.RoomType;

public class RoomBLService_Stub implements RoomBLService{
	public String roomName;
	public String hotelBelongTo;
	public RoomType roomtype;
	public String introdution;
	public double price;
	//status需要存储不可用的时间段，不应采用int数组，具体实现待讨论
	public int[] unavailablePeriod;
	
	//此处的代码和RoomVO的代码相同，不知道算不算是代码复用现象，待讨论
	public RoomBLService_Stub(String r, String h, RoomType t,String i,double p, int[] u){
		this.roomName= r;
		this.hotelBelongTo =h;
		this.roomtype =t;
		this.introdution=i;
		this.price =p;
		this.unavailablePeriod =u;
	}
	//添加房间
	public ResultMessage addRoom(RoomVO r){
		if(r.roomId.equals("0001")){
			return ResultMessage.roomExist;
		}else{
			return ResultMessage.roomNotExist;
		}
	}
	//记录入住信息
	public ResultMessage recordOccupancy (OccupancyVO o){
		if(o.roomId.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//记录退房信息
	public ResultMessage recordCheckout (CheckoutVO c){
		if(c.roomId.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}

}

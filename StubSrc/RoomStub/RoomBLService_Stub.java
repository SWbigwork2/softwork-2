package RoomStub;

import OrderStub.RoomType;

public class RoomBLService_Stub implements RoomBLService{
	public String roomName;
	public String hotelBelongTo;
	public RoomType roomtype;
	public String introdution;
	public double price;
	//status��Ҫ�洢�����õ�ʱ��Σ���Ӧ����int���飬����ʵ�ִ�����
	public int[] unavailablePeriod;
	
	//�˴��Ĵ����RoomVO�Ĵ�����ͬ����֪���㲻���Ǵ��븴�����󣬴�����
	public RoomBLService_Stub(String r, String h, RoomType t,String i,double p, int[] u){
		this.roomName= r;
		this.hotelBelongTo =h;
		this.roomtype =t;
		this.introdution=i;
		this.price =p;
		this.unavailablePeriod =u;
	}
	//��ӷ���
	public ResultMessage addRoom(RoomVO r){
		if(r.roomId.equals("0001")){
			return ResultMessage.roomExist;
		}else{
			return ResultMessage.roomNotExist;
		}
	}
	//��¼��ס��Ϣ
	public ResultMessage recordOccupancy (OccupancyVO o){
		if(o.roomId.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//��¼�˷���Ϣ
	public ResultMessage recordCheckout (CheckoutVO c){
		if(c.roomId.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}

}

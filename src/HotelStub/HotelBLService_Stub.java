package HotelStub;

import java.util.ArrayList;

public class HotelBLService_Stub implements HotelBLService {
	
	//��Ƶ��йص����ԣ�������OrderVO ��ص�����
	String name;
	String address;
	HotelTradeArea tradeArea;
	String introduction;
	String serviceAndFacility;
	HotelRanking ranking;
	
	public HotelBLService_Stub(String n, String a, HotelTradeArea t,String i,String s,HotelRanking r){
		this.name=n;
		this.address=a;
		this.tradeArea=t;
		this.introduction=i;
		this.serviceAndFacility=s;
		this.ranking=r;
	}
	//�����Ƶ귽��
	//?�����Ƶ�������Ƶ�ķ�������ͬ��,��Ҫ����
	public ArrayList <HotelVO> searchHotel(HotelVO h){
		ArrayList <HotelVO> HotelList = new ArrayList<HotelVO>();
		HotelList.add(new HotelVO(name,address,tradeArea,introduction,serviceAndFacility,ranking));
		return HotelList;
	}
	//�鿴�Ƶ�ϸ�ڵķ�����Ҫ����������������������һ��HotelVO��һ��OrderVO
	public HotelVO browseHotelDetail(String name){
		return new HotelVO(name,address,tradeArea,introduction,serviceAndFacility,ranking);
	}
	
	//�˴�û�����OrderVO���캯���Ĳ����������䣡
	public OrderVO getHistoryOrder(){
		return new OrderVO();
	}
	//���۾Ƶ�
	public ResultMessage evaluateHotel(String evaluation,String hotelName){
		if(evaluation.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//���¾Ƶ���Ϣ
	public ResultMessage updateInfo(HotelVO h){
		if(h.name.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//��ӾƵ���Ϣ
	public ResultMessage addHotel(HotelVO h){
		if(h.name.equals("0001")){
			return ResultMessage.hotelExist;
		}else{
			return ResultMessage.hotelNotExist;
		}
	}

}

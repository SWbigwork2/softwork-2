package HotelStub;

import java.util.ArrayList;

public class HotelBLService_Stub implements HotelBLService {
	
	//与酒店有关的属性，待补充OrderVO 相关的属性
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
	//搜索酒店方法
	//?搜索酒店与浏览酒店的方法是相同的,需要讨论
	public ArrayList <HotelVO> searchHotel(HotelVO h){
		ArrayList <HotelVO> HotelList = new ArrayList<HotelVO>();
		HotelList.add(new HotelVO(name,address,tradeArea,introduction,serviceAndFacility,ranking));
		return HotelList;
	}
	//查看酒店细节的方法需要调用以下两个方法，返回一个HotelVO和一个OrderVO
	public HotelVO browseHotelDetail(String name){
		return new HotelVO(name,address,tradeArea,introduction,serviceAndFacility,ranking);
	}
	
	//此处没有添加OrderVO构造函数的参数，待补充！
	public OrderVO getHistoryOrder(){
		return new OrderVO();
	}
	//评价酒店
	public ResultMessage evaluateHotel(String evaluation,String hotelName){
		if(evaluation.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//更新酒店信息
	public ResultMessage updateInfo(HotelVO h){
		if(h.name.equals("0001")){
			return ResultMessage.success;
		}else{
			return ResultMessage.fail;
		}
	}
	//添加酒店信息
	public ResultMessage addHotel(HotelVO h){
		if(h.name.equals("0001")){
			return ResultMessage.hotelExist;
		}else{
			return ResultMessage.hotelNotExist;
		}
	}

}

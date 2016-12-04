package po;

import java.io.Serializable;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import Hotelblimpl.HotelsInfo;

public class HotelPO implements Serializable,HotelsInfo{
	private String name;
	private String address;
	private HotelTradeArea tradeArea;
	private String introduction;
	private String serviceAndFacility;
	private HotelRanking ranking;
	
	public HotelPO(String n, String a, HotelTradeArea t,String i,String s, HotelRanking r ){
		name = n;
		address = a;
		tradeArea = t;
		introduction = i;
		serviceAndFacility = s;
		ranking = r;
	}
	public String getName(){
		return name;
	}
	public String getAddress(){
		return address;
	}
	public HotelTradeArea getTradeArea(){
		return tradeArea;
	}
	public String getIntroduction(){
		return introduction;
	}
	public String getServiceAndFacility(){
		return serviceAndFacility;
	}
	public HotelRanking getRanking(){
		return ranking;
	}

}

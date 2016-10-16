package HotelDataStub;

import java.io.Serializable;

public class HotelPO implements Serializable{
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

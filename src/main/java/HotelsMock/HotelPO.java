package HotelsMock;

import java.io.Serializable;

public class HotelPO implements Serializable,HotelsInfo{
	private String name;
	private String address;
	private HotelTradeArea tradeArea;
	private String introduction;
	private String serviceAndFacility;
	private HotelRanking ranking;
	
	public HotelPO(String name, String address, HotelTradeArea hotelTradeArea,String introduction,String serviceAndFacility, HotelRanking ranking ){
		this.name = name;
		this.address = address;
		this.tradeArea = hotelTradeArea;
		this.introduction = introduction;
		this.serviceAndFacility = serviceAndFacility;
		this.ranking = ranking;
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

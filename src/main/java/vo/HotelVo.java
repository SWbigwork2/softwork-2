package vo;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;

public class HotelVo {
	private String name;
	private String address;
	private HotelTradeArea tradeArea;
	private String introduction;
	private String serviceAndFacility;
	private HotelRanking ranking;

	public HotelVo(String name, String address, HotelTradeArea tradeArea, String introduction,
			String serviceAndFacility, HotelRanking ranking) {
		this.name = name;
		this.address = address;
		this.tradeArea = tradeArea;
		this.introduction = introduction;
		this.serviceAndFacility = serviceAndFacility;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public HotelTradeArea getTradeArea() {
		return tradeArea;
	}

	public void setTradeArea(HotelTradeArea tradeArea) {
		this.tradeArea = tradeArea;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getServiceAndFacility() {
		return serviceAndFacility;
	}

	public void setServiceAndFacility(String serviceAndFacility) {
		this.serviceAndFacility = serviceAndFacility;
	}

	public HotelRanking getRanking() {
		return ranking;
	}

	public void setRanking(HotelRanking ranking) {
		this.ranking = ranking;
	}

}

public class HotelVO {
	String name;
	String address;
	HotelTradeArea tradeArea;
	String introduction;
	String serviceAndFacility;
	HotelRanking ranking;
	
	public HotelVO(String n, String a, HotelTradeArea t,String i,String s, HotelRanking r ){
		name = n;
		address = a;
		tradeArea = t;
		introduction = i;
		serviceAndFacility = s;
		ranking = r;
	}



}

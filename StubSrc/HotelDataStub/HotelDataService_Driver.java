package HotelDataStub;

import java.util.ArrayList;


public class HotelDataService_Driver {
	public void drive(HotelDataService hotelDataService){
		HotelPO h = new HotelPO("0001", "No.111 ZhongshanRoad", null, "clean and convinent",
				"Wifi", HotelRanking.fiveStar);
		ArrayList<HotelPO> hotelList = hotelDataService.find(h);
		if(hotelList.isEmpty()){
			System.out.println("Hotel doesn't exist.");
		}else{
			System.out.println("Hotel  exists.");
		}
		hotelDataService.insert(h);
		hotelDataService.add(h);
		hotelDataService.delete(h);
		hotelDataService.update(h);
	}

}

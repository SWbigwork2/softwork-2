package HotelDataStub;

import java.util.ArrayList;


public class HotelDataServiceTxtFileImpl_Stub implements HotelDataService {

	@Override
	public void insert(HotelPO h) {
		System.out.println("Insert succeed!");

	}

	@Override
	public void add(HotelPO h) {
		System.out.println("Add succeed!");

	}

	@Override
	public void delete(HotelPO h) {
		System.out.println("Delete succeed!");

	}

	@Override
	public void update(HotelPO h) {
		System.out.println("Update succeed!");

	}

	@Override
	public ArrayList<HotelPO> find(HotelPO h) {
		System.out.println("Find succeed!");
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		HotelPO ho = new HotelPO("0001", "No.111 ZhongshanRoad", null, "clean and convinent",
				"Wifi", HotelRanking.fiveStar);
		hotelList.add(ho);
		return hotelList;

	}

}

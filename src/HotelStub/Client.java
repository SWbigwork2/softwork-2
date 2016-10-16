package HotelStub;

public class Client {
	public static void main(String[] args) {
		HotelBLService hotelBLService = new HotelBLService_Stub("1", "2",HotelTradeArea.example , "3", "s", HotelRanking.oneStar);
		HotelBLService_Driver driver = new HotelBLService_Driver();
		driver.drive(hotelBLService);
	}

}

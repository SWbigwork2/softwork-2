package HotelDataStub;


public class Client {
	public static void main(String[] args) {
		HotelDataService impl_stub = new HotelDataServiceMysqlImpl_Stub();
		HotelDataService txt_Stub = new HotelDataServiceTxtFileImpl_Stub();
		HotelDataService serializable_Stub = new HotelDataServiceSerializableImpl_Stub();
		HotelDataService_Driver hotelDataServiceDriver = new HotelDataService_Driver();
		hotelDataServiceDriver.drive(impl_stub);
		hotelDataServiceDriver.drive(txt_Stub);
		hotelDataServiceDriver.drive(serializable_Stub);
	}
}

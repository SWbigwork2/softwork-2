package DataFactoryStub;
import DataFactoryStub4.DataService;
import HotelDataStub.HotelDataService;
import HotelDataStub.HotelDataServiceMysqlImpl_Stub;
import HotelDataStub.HotelDataServiceSerializableImpl_Stub;
import HotelDataStub.HotelDataServiceTxtFileImpl_Stub;
import RoomDataStub.RoomDataService;
import RoomDataStub.RoomDataServiceMysqlImpl_Stub;
import RoomDataStub.RoomDataServiceSerializableImpl_Stub;
import RoomDataStub.RoomDataServiceTxtFileImpl_Stub;

public class DataBaseFactory_Stub {
	public DataService getRoomData_impl() {
		RoomDataService roomDataService = new RoomDataServiceMysqlImpl_Stub();
		return (DataService) roomDataService;
	}

	public DataService getRoomData_txt() {
		RoomDataService roomDataService = new RoomDataServiceTxtFileImpl_Stub();
		return (DataService) roomDataService;
	}

	public DataService getRoomData_serializableImpl() {
		RoomDataService roomDataService = new RoomDataServiceSerializableImpl_Stub();
		return (DataService) roomDataService;
	}
	public DataService getHotelData_impl() {
		HotelDataService hotelDataService = new HotelDataServiceMysqlImpl_Stub();
		return (DataService) hotelDataService;
	}

	public DataService getHotelData_txt() {
		HotelDataService hotelDataService = new HotelDataServiceTxtFileImpl_Stub();
		return (DataService) hotelDataService;
	}

	public DataService getHotelData_serializableImpl() {
		HotelDataService hotelDataService = new HotelDataServiceSerializableImpl_Stub();
		return (DataService) hotelDataService;
	}
	
	
}

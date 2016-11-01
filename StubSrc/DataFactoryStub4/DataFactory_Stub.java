package DataFactoryStub;

import HotelDataStub.HotelDataService;
import HotelDataStub.HotelDataServiceMysqlImpl_Stub;
import HotelDataStub.HotelDataServiceSerializableImpl_Stub;
import HotelDataStub.HotelDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
	public DataService getHotelDate_impl() {
		HotelDataService hotelDataService = new HotelDataServiceMysqlImpl_Stub();
		return (DataService) hotelDataService;
	}

	public DataService getHotelDate_txt() {
		HotelDataService hotelDataService = new HotelDataServiceTxtFileImpl_Stub();
		return (DataService) hotelDataService;
	}

	public DataService getHotelDate_serializableImpl() {
		HotelDataService hotelDataService = new HotelDataServiceSerializableImpl_Stub();
		return (DataService) hotelDataService;
	}

}

package DataFactoryStub;

import RoomDataStub.RoomDataService;
import RoomDataStub.RoomDataServiceMysqlImpl_Stub;
import RoomDataStub.RoomDataServiceSerializableImpl_Stub;
import RoomDataStub.RoomDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
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

}

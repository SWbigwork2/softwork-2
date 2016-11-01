package RoomDataStub;



public class Client {
	public static void main(String[] args) {
		RoomDataService impl_stub = new RoomDataServiceMysqlImpl_Stub();
		RoomDataService txt_Stub = new RoomDataServiceTxtFileImpl_Stub();
		RoomDataService serializable_Stub = new RoomDataServiceSerializableImpl_Stub();
		RoomDataService_Driver roomDataServiceDriver = new RoomDataService_Driver();
		roomDataServiceDriver.drive(impl_stub);
		roomDataServiceDriver.drive(txt_Stub);
		roomDataServiceDriver.drive(serializable_Stub);
	}

}

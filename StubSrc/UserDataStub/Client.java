package UserDataStub;

public class Client {
	public static void main(String[] args) {
		UserDataService impl_stub = new UserDataServiceMysqlImpl_Stub();
		UserDataService txt_Stub = new UserDataServiceTxtFileImpl_Stub();
		UserDataService serializable_Stub = new UserDataServiceSerializableImpl_Stub();
		UserDataService_Drive dateService_Drive = new UserDataService_Drive();
		dateService_Drive.drive(impl_stub);
		dateService_Drive.drive(txt_Stub);
		dateService_Drive.drive(serializable_Stub);
	}
}

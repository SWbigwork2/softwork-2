package MemberDataStub;

public class Client {
	public static void main(String[] args) {
		MemberDataService impl_stub = new MemberDataServiceMysqlImpl_Stub();
		MemberDataService txt_Stub = new MemberDataServiceTxtFileImpl_Stub();
		MemberDataService serializable_Stub = new MemberDataServiceSerializableImpl_Stub();
		MemberDataService_Driver dateService_Driver = new MemberDataService_Driver();
		dateService_Driver.drive(impl_stub);
		dateService_Driver.drive(txt_Stub);
		dateService_Driver.drive(serializable_Stub);
	}
}

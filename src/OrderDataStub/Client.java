package OrderDataStub;

public class Client {
	public static void main(String[] args) {
		OrdersDataService impl_stub = new OrdersDataServiceMysqlImpl_Stub();
		OrdersDataService txt_Stub = new OrdersDataServiceTxtFileImpl_Stub();
		OrdersDataService serializable_Stub = new OrdersDataServiceSerializableImpl_Stub();
		OrderDateService_Driver dateService_Driver = new OrderDateService_Driver();
		dateService_Driver.drive(impl_stub);
		dateService_Driver.drive(txt_Stub);
		dateService_Driver.drive(serializable_Stub);
	}
}

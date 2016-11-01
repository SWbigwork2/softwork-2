package PromotionDataStub;

public class Client {
	public static void main(String[] args) {
		PromotionDataService impl_stub = new PromotionDataServiceMysqlImpl_Stub();
		PromotionDataService txt_Stub = new PromotionDataServiceTxtFileImpl_Stub();
		PromotionDataService serializable_Stub = new PromotionDataServiceSerializableImpl_Stub();
		PromotionDataService_Driver dateService_Driver = new PromotionDataService_Driver();
		dateService_Driver.drive(impl_stub);
		dateService_Driver.drive(txt_Stub);
		dateService_Driver.drive(serializable_Stub);
	}
}

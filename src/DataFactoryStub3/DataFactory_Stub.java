package DataFactoryStub;

import PromotionDataStub.PromotionDataService;
import PromotionDataStub.PromotionDataServiceMysqlImpl_Stub;
import PromotionDataStub.PromotionDataServiceSerializableImpl_Stub;
import PromotionDataStub.PromotionDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
	public DatabaseService getMemberData_impl(){
		PromotionDataService promotionDataService = new PromotionDataServiceMysqlImpl_Stub();
		return (DatabaseService) promotionDataService;
	}
	public DatabaseService getMemberData_txt(){
		PromotionDataService promotionDataService = new PromotionDataServiceTxtFileImpl_Stub();
		return (DatabaseService) promotionDataService;
	}
	public DatabaseService getMemberData_serializableImpl(){
		PromotionDataService promotionDataService = new PromotionDataServiceSerializableImpl_Stub();
		return (DatabaseService) promotionDataService;
	}
	
}

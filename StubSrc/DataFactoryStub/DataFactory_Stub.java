package DataFactoryStub;
import UserDataStub.UserDataService;
import UserDataStub.UserDataServiceMysqlImpl_Stub;
import UserDataStub.UserDataServiceSerializableImpl_Stub;
import UserDataStub.UserDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
	public DataService getUserDate_impl(){
		UserDataService usersDataService = new UserDataServiceMysqlImpl_Stub();
		return (DataService) usersDataService;
	}
	public DataService getUserDate_txt(){
		UserDataService usersDataService = new UserDataServiceTxtFileImpl_Stub();
		return (DataService) usersDataService;
	}
	public DataService getUserDate_serializableImpl(){
		UserDataService usersDataService = new UserDataServiceSerializableImpl_Stub();
		return (DataService) usersDataService;
	}
}

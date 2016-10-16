package DataFactoryStub;

import UserDataStub.UserDataService;
import UserDataStub.UserDataServiceMysqlImpl_Stub;
import UserDataStub.UserDataServiceSerializableImpl_Stub;
import UserDataStub.UserDataServiceTxtFileImpl_Stub;

public class DatabaseFactory_Stub {
	public DatabaseService getUserDate_impl(){
		UserDataService usersDataService = new UserDataServiceMysqlImpl_Stub();
		return (DatabaseService) usersDataService;
	}
	public DatabaseService getUserDate_txt(){
		UserDataService UsersDataService = new UserDataServiceTxtFileImpl_Stub();
		return (DatabaseService) UsersDataService;
	}
	public DatabaseService getUserDate_serializableImpl(){
		UserDataService UsersDataService = new UserDataServiceSerializableImpl_Stub();
		return (DatabaseService) UsersDataService;
	}
	


}

package DataFactoryStub;

import MemberDataStub.MemberDataService;
import MemberDataStub.MemberDataServiceMysqlImpl_Stub;
import MemberDataStub.MemberDataServiceSerializableImpl_Stub;
import MemberDataStub.MemberDataServiceTxtFileImpl_Stub;

public class DatabaseFactory_Stub {
	public DatabaseService getMemberData_impl(){
		MemberDataService memberDataService = new MemberDataServiceMysqlImpl_Stub();
		return (DatabaseService) memberDataService;
	}
	public DatabaseService getMemberData_txt(){
		MemberDataService memberDataService = new MemberDataServiceTxtFileImpl_Stub();
		return (DatabaseService) memberDataService;
	}
	public DatabaseService getMemberData_serializableImpl(){
		MemberDataService memberDataService = new MemberDataServiceSerializableImpl_Stub();
		return (DatabaseService) memberDataService;
	}
	

}

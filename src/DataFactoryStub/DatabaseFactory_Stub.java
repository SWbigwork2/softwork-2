package DataFactoryStub;


import OrderDataStub.OrdersDataService;
import OrderDataStub.OrdersDataServiceMysqlImpl_Stub;
import OrderDataStub.OrdersDataServiceSerializableImpl_Stub;
import OrderDataStub.OrdersDataServiceTxtFileImpl_Stub;
import UserDataStub.UserDataService;
import UserDataStub.UserDataServiceMysqlImpl_Stub;
import UserDataStub.UserDataServiceSerializableImpl_Stub;
import UserDataStub.UserDataServiceTxtFileImpl_Stub;

public class DatabaseFactory_Stub {
	public DataService getUserDate_impl(){
		UserDataService usersDataService = new UserDataServiceMysqlImpl_Stub();
		return usersDataService;
	}
	public DataService getUserDate_txt(){
		UserDataService userDataServiceser = new UserDataServiceTxtFileImpl_Stub();
		return userDataServiceser;
	}
	public DataService getUserDate_serializableImpl(){
		UserDataService usersDataService = new UserDataServiceSerializableImpl_Stub();
		return usersDataService;
	}
	public DataService getOrderDate_impl(){
		OrdersDataService ordersDataService = new OrdersDataServiceMysqlImpl_Stub();
		return ordersDataService;
	}
	public DataService getOrderDate_txt(){
		OrdersDataService ordersDataService = new OrdersDataServiceTxtFileImpl_Stub();
		return ordersDataService;
	}
	public DataService getOrderDate_serializableImpl(){
		OrdersDataService ordersDataService = new OrdersDataServiceSerializableImpl_Stub();
		return ordersDataService;
	}
	


}

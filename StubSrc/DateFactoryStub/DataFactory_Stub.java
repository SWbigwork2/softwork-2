package DateFactoryStub;

import OrderDataStub.OrdersDataService;
import OrderDataStub.OrdersDataServiceMysqlImpl_Stub;
import OrderDataStub.OrdersDataServiceSerializableImpl_Stub;
import OrderDataStub.OrdersDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
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

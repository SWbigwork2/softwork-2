package data.dataHelper.impl;

import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.OrdersDataHelper;
import data.dataHelper.UserDataHelper;

public class DataFactoryImpl implements DataFactory{

	public OrdersDataHelper getOrdersDataHelper() {
		OrdersDataHelper order = new OrdersDataSqlHelper();
		// TODO Auto-generated method stub
		return order;
	}
	
	public UserDataHelper getUserDataHelper(){
        UserDataHelper userDataHelper= new UserDataSqlHelper();
        // TODO Auto-generated method stub
        return userDataHelper;
	}

	public EvaluateDataHelper getEvaluateDataHelper() {
		// TODO Auto-generated method stub
		EvaluateDataHelper evaluateDataHelper=new EvaluateDataSqlHelper();
		return evaluateDataHelper;
	}

}

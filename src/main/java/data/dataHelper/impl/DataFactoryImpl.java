package data.dataHelper.impl;

import data.dataHelper.DataFactory;
import data.dataHelper.OrdersDataHelper;

public class DataFactoryImpl implements DataFactory{

	public OrdersDataHelper getOrdersDataHelper() {
		OrdersDataHelper order = new OrdersDataSqlHelper();
		// TODO Auto-generated method stub
		return order;
	}

}
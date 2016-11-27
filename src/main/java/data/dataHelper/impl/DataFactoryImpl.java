package data.dataHelper.impl;

import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.MembersDataHelper;
import data.dataHelper.OrdersDataHelper;
import data.dataHelper.PromotionsDataHelper;
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
        public MembersDataHelper getMembersDataHelper() {
		// TODO Auto-generated method stub
		MembersDataHelper member=new MembersDataSqlHelper();
		return member;
	}
        public PromotionsDataHelper getPromtionsDataHelper() {
		// TODO Auto-generated method stub
		PromotionsDataHelper promotion =new PromotionsDataSqlHelper();
		return promotion;
	}

}

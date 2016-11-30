package data.dataHelper;

import data.dataHelper.impl.MembersDataSqlHelper;

public interface DataFactory {
	
	public OrdersDataHelper getOrdersDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();
	
	public PromotionsDataHelper getPromotionsDataHelper();
	
	public MembersDataSqlHelper getMembersDataHelper();
}

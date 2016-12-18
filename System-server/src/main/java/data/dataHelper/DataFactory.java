package data.dataHelper;

import data.dataHelper.impl.MembersDataSqlHelper;

public interface DataFactory {
	 public MembersDataHelper getMembersDataHelper();
	public OrdersDataHelper getOrdersDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();
	
	public PromotionsDataHelper getPromtionsDataHelper();
	
	public HotelsDataHelper getHotelsDataHelper();
	
	public RoomsDataHelper getRoomsDataHelper();
}

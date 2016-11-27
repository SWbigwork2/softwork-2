package data.dataHelper;

public interface DataFactory {
	
	public OrdersDataHelper getOrdersDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();
}

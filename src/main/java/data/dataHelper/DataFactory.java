package data.dataHelper;

public interface DataFactory {
	
	public OrdersDataHelper getOrdersDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();

        public MembersDataHelper getMembersDataHelper();
	
	public PromotionsDataHelper getPromtionsDataHelper();
	
	public HotelsDataHelper getHotelsDataHelper();
	
	public RoomsDataHelper getRoomsDataHelper();
}

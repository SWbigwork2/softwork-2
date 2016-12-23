package data.dataHelper;



/**
 * @author 朱润之
 * 工厂模式，用于创建对象
 */
public interface DataFactory {
	 public MembersDataHelper getMembersDataHelper();
	public OrdersDataHelper getOrdersDataHelper();
	
	public UserDataHelper getUserDataHelper();
	
	public EvaluateDataHelper getEvaluateDataHelper();
	
	public PromotionsDataHelper getPromtionsDataHelper();
	
	public HotelsDataHelper getHotelsDataHelper();
	
	public RoomsDataHelper getRoomsDataHelper();
}

package ordersblimpl;

/**
 * @author 朱润之
 * 从memberservice中抽离的接口，用于更新订单信息以及得到用户的level
 */
public interface MembersInfo {
	public String getMemberLevel(String membersId);
	public boolean updateMemberCredit(String id,double changecredit,int orderid,String action);

}

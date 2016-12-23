package ordersblimpl;

public interface MembersInfo {
	public String getMemberLevel(String membersId);
	public boolean updateMemberCredit(String id,double changecredit,int orderid,String action);

}

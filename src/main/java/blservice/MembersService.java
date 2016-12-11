package blservice;

import java.util.ArrayList;

import po.CreditrecordPO;
import po.MemberPO;
import view.member.OrderVo;

public interface MembersService {
	public  ArrayList<OrderVo>  getOrder(String id);
    public  ArrayList<String> getHotel(String id);
    public MemberPO getMember(String id) ;
    public boolean updateMemberCredit(String id,double changecredit,int orderid,String action);
    public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid);
    public void insertCreditRecord(CreditrecordPO po);
}

package data.dataHelper;


import java.util.ArrayList;

import po.CreditrecordPO;
import po.MemberPO;

public interface MembersDataHelper {
	public MemberPO getMember(String id);
    public boolean updateMemberCredit(String id,double changecredit);
    public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid);//查看用户历史信用记录
    public void insertCreditRecord(CreditrecordPO po);//插入用户信用记录到数据库
}

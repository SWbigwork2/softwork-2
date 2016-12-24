package data.dataHelper;


import java.util.ArrayList;

import po.CreditrecordPO;
import po.MemberPO;

public interface MembersDataHelper {
	/**
	 * @param id
	 * @return 得到会员信息
	 */
	public MemberPO getMember(String id);
	
    /**
     * @param id
     * @param changecredit
     * @return 更新用户信用记录
     */
    public boolean updateMemberCredit(String id,double changecredit);
    
    /**
     * @param memberid
     * @return得到用户历史信用
     */
    public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid);
    /**
     * @param po
     * 插入用户信用记录到数据库
     */
    public void insertCreditRecord(CreditrecordPO po);
}

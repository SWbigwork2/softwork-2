package data.dao;


import java.util.ArrayList;


import po.CreditrecordPO;
import po.MemberPO;

public interface MembersDao {
      public MemberPO getMember(String id) ;//获得用户信息
      public  boolean updateCredit(String id,double changecredit);//修改用户信用
      public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid);//查看用户历史信用记录
      public void insertCreditRecord(CreditrecordPO po);//插入用户信用记录到数据库
}

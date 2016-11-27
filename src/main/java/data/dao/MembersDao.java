package data.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import MembersMock.ResultMessage;
import OrdersMock.OrderVO;
import po.MemberInformationPO;
import po.MemberPO;

public interface MembersDao {
      public MemberInformationPO getMember(String id) throws SQLException;//获得用户信息
      public  boolean updateCredit(String id,double changecredit);//修改用户信用
}

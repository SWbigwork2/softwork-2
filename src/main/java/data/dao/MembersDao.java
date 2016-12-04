package data.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Membersblimpl.ResultMessage;

import po.MemberPO;

public interface MembersDao {
      public MemberPO getMember(String id) throws SQLException;//获得用户信息
      public  boolean updateCredit(String id,double changecredit);//修改用户信用
}

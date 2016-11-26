package data.dao;

import java.util.ArrayList;

import MembersMock.ResultMessage;
import OrdersMock.OrderVO;
import po.MemberPO;

public interface MembersDao {
      public MemberPO getMember(String id);//获得用户信息
      public  ResultMessage updateCredit(String id,double changecredit);//修改用户信用
}

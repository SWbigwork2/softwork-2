package data.dataservice;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import po.CreditrecordPO;
import po.MemberPO;

public interface MembersDao extends Remote{
      public MemberPO getMember(String id) throws RemoteException ;//获得用户信息
      public  boolean updateCredit(String id,double changecredit)throws RemoteException;//修改用户信用
      public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid)throws RemoteException;//查看用户历史信用记录
      public void insertCreditRecord(CreditrecordPO po)throws RemoteException;//插入用户信用记录到数据库
}

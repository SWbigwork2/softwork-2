package data.dao;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


import po.CreditrecordPO;
import po.MemberPO;

/**
 * @author 张磊
 *member模块的数据层接口
 */
public interface MembersDao extends Remote{
      /**
     * @param id
     * @return 得到会员信息
     * @throws RemoteException
     */
    public MemberPO getMember(String id) throws RemoteException ;
      /**
     * @param id
     * @param changecredit
     * @return 修改用户信用
     * @throws RemoteException
     */
    public  boolean updateCredit(String id,double changecredit)throws RemoteException;
      /**
     * @param memberid
     * @return 查看用户历史信用记录
     * @throws RemoteException
     */
    public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid)throws RemoteException;
      /**
     * @param po
     * 插入用户信用记录到数据库
     * @throws RemoteException
     */
    public void insertCreditRecord(CreditrecordPO po)throws RemoteException;
}

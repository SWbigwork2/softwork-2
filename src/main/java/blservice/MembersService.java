package blservice;

import java.util.ArrayList;
import java.util.Map;

import ordersblimpl.OrderType;
import po.CreditrecordPO;
import po.MemberPO;
import vo.OrderVo;


public interface MembersService {
	/**
	 * @param id
	 * @return 得到历史订单
	 */
	public  ArrayList<OrderVo>  getOrder(String id);
	
	/**
	 * @param  id
	 * @return  得到历史酒店
	 */
	 public  ArrayList<String> getHotel(String id);
    
    /**
   	 * @param id
   	 * @return  得到会员信息
   	 */
    public MemberPO getMember(String id) ;
    
    /**
	 * @param id,changecredit,orderid,action
	 * @return  更新会员信用和记录
	 */
    public boolean updateMemberCredit(String id,double changecredit,int orderid,String action);
    
    /**
	 * @param memberid
	 * @return 得到会员信用记录
	 */
    public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid);
    
    /**
	 * @param po
	 * @return  插入信用记录
	 */
    public void insertCreditRecord(CreditrecordPO po);
}

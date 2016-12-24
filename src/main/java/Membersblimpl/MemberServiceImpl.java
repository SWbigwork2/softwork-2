package Membersblimpl;

import java.rmi.Remote;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import blservice.MembersService;
import blservice.OrdersService;
import data.dao.MembersDao;
import data.rmi.RemoteHelper;
import ordersblimpl.MembersInfo;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import po.CreditrecordPO;
import po.MemberPO;
import vo.OrderVo;



public class MemberServiceImpl implements MembersService,MembersInfo{
	public MemberServiceImpl() {
		
		remoteHelper = RemoteHelper.getInstance();
		membersDao = remoteHelper.getMembersDao();
		// TODO Auto-generated constructor stub
	}
    MembersDao membersDao;
	ResultMessage result=ResultMessage.Success;
	OrdersService ordersService;
	RemoteHelper remoteHelper;
	/**
	 * @param id
	 * @return 得到历史订单
	 */
    public  ArrayList<OrderVo> getOrder(String id){
    	ordersService = new OrderServiceImpl();
    	
		return ordersService.getOrderList(id,OrderType.all);
    	
    }
    /**
	 * @param  id
	 * @return  得到历史酒店
	 */
    public ArrayList<String> getHotel(String id){
    	ordersService = new OrderServiceImpl();
    	
    	return ordersService.getHotelList(id);
		
    	
    }
    /**
   	 * @param id
   	 * @return  得到会员信息
   	 */
	@Override
	public MemberPO getMember(String id) {
		
		// TODO Auto-generated method stub
		return membersDao.getMember(id);
	}
	/**
	 * @param id,changecredit,orderid,action
	 * @return  更新会员信用和记录
	 */
	@Override
	public boolean updateMemberCredit(String id, double changecredit,int orderid,String action) {
		ordersService = new OrderServiceImpl();
		// TODO Auto-generated method stub
		MemberPO memberPO=getMember(id);
		double totalcredit=changecredit+memberPO.getCredit();
		 DateFormat df = DateFormat.getDateInstance();
		 Date date=new Date();
		String time =df.format(date);
		CreditrecordPO creditrecordPO=new CreditrecordPO(id, time, orderid, action, changecredit, totalcredit);
		membersDao.insertCreditRecord(creditrecordPO);
		return membersDao.updateCredit(id, totalcredit);
	}
	/**
	 * @param memberid
	 * @return 得到会员信用记录
	 */
	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		ordersService = new OrderServiceImpl();
		// TODO Auto-generated method stub
		return membersDao.getMemberCreditRecord(memberid);
	}
	/**
	 * @param po
	 * @return  插入信用记录
	 */
	@Override
	public void insertCreditRecord(CreditrecordPO po) {
		ordersService = new OrderServiceImpl();
		// TODO Auto-generated method stub
		membersDao.insertCreditRecord(po);
	}
	@Override
	public String getMemberLevel(String membersId) {
		// TODO Auto-generated method stub
		return "lv"+getMember(membersId).getLevel();
	}
}

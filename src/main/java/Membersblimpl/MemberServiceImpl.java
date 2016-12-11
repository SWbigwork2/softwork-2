package Membersblimpl;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import blservice.MembersService;
import blservice.OrdersService;
import data.dao.MembersDao;
import data.dao.impl.MembersDaoImpl;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import po.CreditrecordPO;
import po.MemberPO;
import view.member.OrderVo;


public class MemberServiceImpl implements MembersService{
	public MemberServiceImpl() {
		
		// TODO Auto-generated constructor stub
	}
    MembersDao membersDao=new MembersDaoImpl();
	ResultMessage result=ResultMessage.Success;
	OrdersService ordersService=new OrderServiceImpl();
	
    public  ArrayList<OrderVo> getOrder(String id){
    	
		return ordersService.getOrderList(id,OrderType.all);
    	
    }
    public  ArrayList<String> getHotel(String id){
    	
    	return ordersService.getHotelList(id);
		
    	
    }
	@Override
	public MemberPO getMember(String id) {
		// TODO Auto-generated method stub
		return membersDao.getMember(id);
	}
	@Override
	public boolean updateMemberCredit(String id, double changecredit,int orderid,String action) {
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
	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		return membersDao.getMemberCreditRecord(memberid);
	}
	@Override
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		membersDao.insertCreditRecord(po);
	}
}

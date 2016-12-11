package Membersblimpl;

import java.util.ArrayList;

import blservice.MembersService;
import blservice.OrdersService;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import po.MemberPO;
import view.member.OrderVo;


public class MemberServiceImpl implements MembersService{
	public MemberServiceImpl() {
		
		// TODO Auto-generated constructor stub
	}

	ResultMessage result=ResultMessage.Success;
	OrdersService ordersService=new OrderServiceImpl();
	MembersService membersService=new MemberServiceImpl();
    public  ArrayList<OrderVo> getOrder(String id){
    	
		return ordersService.getOrderList(id,OrderType.all);
    	
    }
    public  ArrayList<String> getHotel(String id){
    	
    	return ordersService.getHotelList(id);
		
    	
    }
	@Override
	public MemberPO getMember(String id) {
		// TODO Auto-generated method stub
		return membersService.getMember(id);
	}
	@Override
	public boolean updateMemberCredit(String id, double changecredit) {
		// TODO Auto-generated method stub
		MemberPO memberPO=membersService.getMember(id);
		double totalcredit=changecredit+memberPO.getCredit();
		
		return membersService.updateMemberCredit(id, totalcredit);
	}
}

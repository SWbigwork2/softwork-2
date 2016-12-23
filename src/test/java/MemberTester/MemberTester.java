package MemberTester;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import Membersblimpl.MemberServiceImpl;
import blservice.MembersService;
import blservice.OrdersService;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import ordersblimpl.OrderType;
import po.MemberPO;

public class MemberTester {

private RemoteHelper remoteHelper;
	
	public void linkToServer(){
		final String ip = "localhost";
		try{
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://"+ip+":8888/DateRemoteObject"));
			System.out.println("linked");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void getOrderTester(){
		MembersService membersService=new MemberServiceImpl();
		OrdersService ordersService=new OrderServiceImpl();
		assertEquals(ordersService.getOrderList("1000", OrderType.all), membersService.getOrder("1000"));
		
	}
	@Test
	public void updateCreditTester(){
		MemberPO testpo=new MemberPO("1000", "王明","1111" , "13109290200", 300,null,0,1);
		MembersService membersService=new MemberServiceImpl();
		assertTrue(membersService.updateMemberCredit("1000", 100, 0, "信用充值"));
	}
	

}

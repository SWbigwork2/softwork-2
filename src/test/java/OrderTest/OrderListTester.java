package OrderTest;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import blservice.OrdersService;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;

public class OrderListTester {
	OrdersService orderService;
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
	@Before
	public void setup(){
		
		linkToServer();
		orderService = new OrderServiceImpl();
	}
	/**
	 * 得到酒店订单的测试
	 */
	@Test
	public void hotelOrderTest() {
		ArrayList<OrderVo> testList = orderService.getHotelOrder("金陵饭店");
		assertEquals(testList.size(), 6);
		
	}

}

package OrderTest;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import blservice.OrdersService;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import vo.OrderVo;

public class OrderCheckTester {
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
	@Test
	public void checkTest(){
		orderService.checkOrder();
		OrderVo vo = orderService.getOrder(111111);
		assertEquals(vo.getType(), "error");
	}
}

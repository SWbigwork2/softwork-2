package data.orderTester;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Roomblimpl.RoomType;
import data.dao.OrdersDao;

import data.dao.impl.OrdersDaoImpl;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderType;
import po.OrderPO;

public class getOrderListTester {
	private RemoteHelper remoteHelper;
	
	OrderPO testPo = new OrderPO(111111, "1000", "admin", "皇朝", RoomType.单人间, 1, 200.0, OrderType.done, new Date(), new Date(), new Date(), new Date(),1, new Date(), false);
	@Test
	public void test() {
		OrdersDao dao = OrdersDaoImpl.getInstance();
		try{
		assertTrue(dao.insert(testPo));
		ArrayList<OrderPO> pOList = dao.getOrderList("admin");
		OrderPO tempPo = null;
		
		
		for(OrderPO po:pOList){
			if(po.getOrderId()==testPo.getOrderId()){
				tempPo = po;
			}
		}
		assertEquals(testPo, tempPo);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}

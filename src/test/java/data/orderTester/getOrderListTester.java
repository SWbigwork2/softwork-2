package data.orderTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import RoomsMock.RoomType;
import data.dao.OrdersDao;
import data.dao.impl.OrdersDaoImpl;
import ordersblimpl.OrderType;
import po.OrderPO;

public class getOrderListTester {
	OrderPO testPo = new OrderPO(0001, "admin", "admin", "皇朝", RoomType.big, 1, 200.0, OrderType.normal, new Date(), new Date(), new Date(), new Date(),1, new Date(), false);
	@Test
	public void test() {
		OrdersDao dao = OrdersDaoImpl.getInstance();
		assertTrue(dao.insert(testPo));
		ArrayList<OrderPO> pOList = dao.getOrderList("admin");
		OrderPO tempPo = null;
		
		for(OrderPO po:pOList){
			if(po.getOrderId()==testPo.getOrderId()){
				tempPo = po;
			}
		}
		assertEquals(testPo, tempPo);
	}

}

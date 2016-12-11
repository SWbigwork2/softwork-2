package data.orderTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import Roomblimpl.RoomType;
import data.dao.OrdersDao;
import data.dao.impl.OrdersDaoImpl;
import ordersblimpl.OrderType;
import po.OrderPO;

public class getOrderListTester {
	OrderPO testPo = new OrderPO(0002, "1000", "admin", "皇朝", RoomType.单人间, 1, 200.0, OrderType.done, new Date(), new Date(), new Date(), new Date(),1, new Date(), false);
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

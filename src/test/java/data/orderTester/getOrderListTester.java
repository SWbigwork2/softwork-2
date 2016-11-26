package data.orderTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import OrdersMock.OrderType;
import RoomsMock.RoomType;
import data.dao.OrdersDao;
import data.dao.impl.OrdersDaoImpl;
import po.OrderPO;

public class getOrderListTester {
	OrderPO testPo = new OrderPO(0005, "1111", "皇朝", RoomType.big, 1, 200.0, OrderType.normal, new Date(2013, 12, 16), new Date(2013, 12, 18), new Date(2013, 12, 18,20,15),  new Date(2013, 12, 18,19,00), 1,new Date());
	@Test
	public void test() {
		OrdersDao dao = OrdersDaoImpl.getInstance();
		assertTrue(dao.insert(testPo));
		ArrayList<OrderPO> pOList = dao.getOrderList("1111");
		OrderPO tempPo = null;
		
		for(OrderPO po:pOList){
			if(po.getOrderId()==testPo.getOrderId()){
				tempPo = po;
			}
		}
		assertEquals(testPo, tempPo);
	}

}

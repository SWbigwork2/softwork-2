package data.orderTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import OrdersMock.OrderType;
import RoomsMock.RoomType;
import data.dao.OrdersDao;
import data.dao.impl.OrdersDaoImpl;
import po.OrderPO;

public class OrderTester {   
	OrderPO testPo = new OrderPO(0005, "1111", "皇朝", RoomType.big, 1, 200.0, OrderType.normal, new Date(2013, 12, 16), new Date(2013, 12, 18), new Date(2013, 12, 18,20,15),  new Date(2013, 12, 18,19,00), 1,new Date());
	//@Test
	/*public void insert_GetTest() {     //插入和得到列表的测试
		OrdersDao dao = OrdersDaoImpl.getInstance();
		assertTrue(dao.insert(testPo));
		ArrayList<OrderPO> pOList = dao.getOrderList("1111");
		OrderPO tempPo = null;
		boolean isRight = false;
		for(OrderPO po:pOList){
			if(isEqual(po, tempPo)){
				isRight = true;
			}
		}
		assert(isRight);
	}*/
	
	@Test
	public void getOrderTest(){   //根据id查找order的测试
		OrdersDao dao = OrdersDaoImpl.getInstance();
		OrderPO po = dao.getOrder(0005);
		assertTrue(isEqual(po, testPo));
	}
	
	@Test
	public void getHotelOrderListTest(){		//根据酒店名查找order列表的测试
		OrdersDao dao = OrdersDaoImpl.getInstance();
		ArrayList<OrderPO> test1 = dao.getHotelOrderList("皇朝");
		ArrayList<OrderPO> test2 = dao.getHotelOrderList("");
		assertEquals(1,test1.size());
		assertEquals(0, test2.size());
	}
	private boolean isEqual(Object obj1,Object obj2){       //比较两个类是否相同
		Field[] f1 = obj1.getClass().getDeclaredFields();
		Field[] f2 = obj1.getClass().getDeclaredFields();
		for(int i=0;i<f1.length;i++){
			if(!f1[i].equals(f2[i])){
				return false;
			}
		}
		return true;
	}

}

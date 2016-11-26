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

public class OrderInsertAndDeleteTester {
	OrderPO testPo = new OrderPO(0005, "1111", "皇朝", RoomType.big, 1, 200.0, OrderType.normal, new Date(2013, 12, 16), new Date(2013, 12, 18), new Date(2013, 12, 18,20,15),  new Date(2013, 12, 18,19,00), 1,new Date());
	@Test
	public void insert_GetTest() {     //插入和得到列表的测试
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
	}
	@Test
	public void deleteTest(){ //删除的测	试
		
		OrdersDao dao = OrdersDaoImpl.getInstance();
		int preNum = dao.getOrderList("1111").size();
		assertTrue(dao.delete(0005));
		assertEquals(false, dao.delete(0000));
		int afterNum = dao.getOrderList("1111").size();
		assertEquals(1, preNum-afterNum);
		
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

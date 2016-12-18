package data.orderTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import Roomblimpl.RoomType;
import data.dao.OrdersDao;
import data.dao.impl.OrdersDaoImpl;
import ordersblimpl.OrderType;
import po.OrderPO;

public class OrderInsertAndDeleteTester {
	OrderPO testPo = new OrderPO(123457, "admin", "admin", "皇朝", RoomType.单人间, 1, 200.0, OrderType.normal, new Date(), new Date(), new Date(), new Date(),1, new Date(), false);
	@Test
	public void insert_GetTest() {     //插入和得到列表的测试
		OrdersDao dao = OrdersDaoImpl.getInstance();
		try {
			assertTrue(dao.insert(testPo));
			ArrayList<OrderPO> pOList = dao.getOrderList("admin");
			OrderPO tempPo = null;
			boolean isRight = false;
			for(OrderPO po:pOList){
				if(isEqual(po, tempPo)){
					isRight = true;
				}
			}
			assert(isRight);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void deleteTest(){ //删除的测	试
		
		OrdersDao dao = OrdersDaoImpl.getInstance();
		int preNum;
		try {
			preNum = dao.getOrderList("admin").size();
			assertTrue(dao.delete(123457));
			assertEquals(false, dao.delete(0000));
			int afterNum = dao.getOrderList("admin").size();
			assertEquals(1, preNum-afterNum);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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

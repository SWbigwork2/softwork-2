package data.promotionTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.PromotionsDao;
import data.dao.impl.PromotionsDaoImpl;
import po.PromotionsPO;
import po.PromotionsVIPO;

public class getHotelPromotionsTester {

	@Test
	public void test() throws RemoteException {
		 ArrayList<PromotionsPO> testlist=new ArrayList<PromotionsPO>();
		 PromotionsVIPO promotionsVIPO=new PromotionsVIPO(6, "假日酒店", "vip1打九折", 1, 0.9);
		 testlist.add(promotionsVIPO);
		 PromotionsDao dao =PromotionsDaoImpl.getInstance();
		 ArrayList<PromotionsPO> list= dao.getHotelPromotions("假日酒店");
		 assertTrue(isEqual(testlist, list));
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

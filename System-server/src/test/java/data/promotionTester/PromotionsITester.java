package data.promotionTester;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import data.dao.PromotionsDao;
import data.dao.impl.PromotionsDaoImpl;
import po.PromotionsIPO;
@FixMethodOrder(MethodSorters.JVM)
public class PromotionsITester {
           PromotionsIPO po=new PromotionsIPO(1, "七天", "生日特惠打八折", 0.8);
	@Test
	public void addPromotionsItest() throws RemoteException {
		PromotionsDao dao =PromotionsDaoImpl.getInstance();
		 assertTrue(dao.addPromotionsI(po));
		 assertFalse(dao.addPromotionsI(po));
	}
	@Test
	public void deletePromotionstest() throws RemoteException{
		 PromotionsDao dao =PromotionsDaoImpl.getInstance();
		 assertTrue(dao.deletePromotions(po));
		 assertFalse(dao.deletePromotions(po));
	}

}

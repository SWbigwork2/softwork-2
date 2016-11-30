package data.promotionTester;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.MembersDao;
import data.dao.PromotionsDao;
import data.dao.impl.MembersDaoImpl;
import data.dao.impl.PromotionsDaoImpl;
import po.PromotionsIPO;

public class PromotionsITester {
    PromotionsIPO po=new PromotionsIPO(1, "七天", "生日特惠打八折", 0.8);
       PromotionsIPO po2=new PromotionsIPO(1,"豪庭","生日特惠打九折",0.9);
@Test
public void addPromotionsItest() {
	 PromotionsDao dao =PromotionsDaoImpl.getInstance();
	 assertTrue(dao.addPromotionsI(po));
	 assertFalse(dao.addPromotionsI(po));
}

@Test
public void deletePromotionstest(){
	
	 PromotionsDao dao =PromotionsDaoImpl.getInstance();
	 dao.addPromotionsI(po2);
	 assertTrue(dao.deletePromotions(po2));
	 assertFalse(dao.deletePromotions(po2));
}
}

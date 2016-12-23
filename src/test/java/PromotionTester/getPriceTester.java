package PromotionTester;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Test;

import Promotionsblimpl.PriceInfo;
import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;

public class getPriceTester {

	@Test
	public void getPriceTester(){
		PromotionsService promotionsService=new PromotionsServiceImpl();
		PriceInfo pro=new PriceInfo("双十一活动打六折", 240);
		assertTrue(isEqual(pro, promotionsService.getPrice("皇冠大酒店", 100, 1, "1000", 3)));
		
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

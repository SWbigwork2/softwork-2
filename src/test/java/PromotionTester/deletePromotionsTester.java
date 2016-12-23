package PromotionTester;

import static org.junit.Assert.*;

import org.junit.Test;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import view.staff.PromotionsIVO;

public class deletePromotionsTester {

	@Test
	public void deletePromotionsTester(){
		PromotionsIVO promotionsIVO=new PromotionsIVO(1, "七天", "生日特惠打五折", 0.5);
		PromotionsService promotionsService=new PromotionsServiceImpl();
		promotionsService.addPromotionsI(promotionsIVO);
		assertTrue(promotionsService.deletePromotions(promotionsIVO));
		
	}

}

package EvaluateTester;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Evaluateblimpl.Evaluateblimpl;
import Evaluateblimpl.ResultMessage;
import Hotelblimpl.HotelServiceImpl;
import blservice.EvaluateService;
import blservice.HotelService;
import po.EvaluatePO;



public class EvaluateTester {
	
	    
//	@Test
	public void evaluateTester(){
		Evaluateblimpl em=new Evaluateblimpl();	
		EvaluatePO evaluatePO=new EvaluatePO("金陵饭店",4,"good","我去1949");
		assertEquals(ResultMessage.success,em.evaluate(evaluatePO));
	}
	
//	@Test
	public void getListTest(){
		EvaluateService evaluateblimpl=new Evaluateblimpl();
		ArrayList<String > list=evaluateblimpl.getComments("南京夜泊秦淮君亭酒店");
		assertEquals(2, list.size());
	}
	
	@Test
	public void getScoreList(){
		EvaluateService evaluateService=new Evaluateblimpl();
		ArrayList<Double> list=evaluateService.getScore("南京夜泊秦淮君亭酒店");
		assertEquals(3, list.size());
	}
}

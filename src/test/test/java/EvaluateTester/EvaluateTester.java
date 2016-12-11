package EvaluateTester;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Evaluateblimpl.Evaluateblimpl;
import Evaluateblimpl.ResultMessage;
import blservice.EvaluateService;
import po.EvaluatePO;



public class EvaluateTester {
	
	    
//	@Test
	public void evaluateTester(){
		Evaluateblimpl em=new Evaluateblimpl();	
		EvaluatePO evaluatePO=new EvaluatePO("如家",4,"good","哈哈");
		assertEquals(ResultMessage.success,em.evaluate(evaluatePO));

	}
	
	@Test
	public void getListTest(){
		EvaluateService evaluateblimpl=new Evaluateblimpl();
		ArrayList<String > list=evaluateblimpl.getComments("如家");
		assertEquals(2, list.size());
	}
	
}

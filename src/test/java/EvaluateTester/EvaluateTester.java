package EvaluateTester;
import static org.junit.Assert.*;

import org.junit.Test;

import EvaluateMock.ResultMessage;
import EvaluateMock.EvaluateMock;

public class EvaluateTester {
	
	    
	@Test
	public void evaluateTester(){
		EvaluateMock em=new EvaluateMock("如家","1011", 1234);	
		assertEquals(ResultMessage.success,em.evaluate( "如家","1011", 1234,3,"good"));
//		assertEquals(em.evaluate("朝", "0001", 1234, 3,"good"),ResultMessage.fail);
//		assertEquals(em.evaluate("皇朝", "001", 1234, 3,"good"),ResultMessage.fail);
//		assertEquals(em.evaluate("皇朝", "0001", 134, 3,"good"),ResultMessage.fail);
//		assertEquals(em.evaluate("皇朝", "0001", 1234, 6,"good"),ResultMessage.fail);
	}
	
}

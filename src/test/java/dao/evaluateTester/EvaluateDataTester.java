package dao.evaluateTester;

import static org.junit.Assert.*;

import org.junit.Test;

import EvaluateMock.ResultMessage;
import data.dao.EvaluateDao;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class EvaluateDataTester {

	@Test
	public void addEvalaute() {
		EvaluatePO evaluatePO=new EvaluatePO("蛤ha", "1050", 4.3, "good");
	    EvaluateDao dao=EvaluateDaoImpl.getInstance();
		ResultMessage reusltMessage=ResultMessage.success;
		assertEquals(reusltMessage,dao.addEvaluate(evaluatePO));
	}
	
	@Test
	public void getEvalaute() {
	    EvaluateDao dao=EvaluateDaoImpl.getInstance();
		assertEquals(2,dao.getEvaluatetion("如家酒店").size());
	}

}

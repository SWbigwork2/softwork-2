package dao.evaluateTester;

import static org.junit.Assert.*;

import org.junit.Test;

import Evaluateblimpl.ResultMessage;
import data.dao.EvaluateDataService;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class EvaluateDataTester {

	@Test
	public void addEvalaute() {
		EvaluatePO evaluatePO=new EvaluatePO("金陵饭店", 4.3, "good","李华");
	    EvaluateDataService dao=EvaluateDaoImpl.getInstance();
		ResultMessage reusltMessage=ResultMessage.success;
		assertEquals(reusltMessage,dao.addEvaluate(evaluatePO));
	}
	
	@Test
	public void getEvalaute() {
	    EvaluateDataService dao=EvaluateDaoImpl.getInstance();
		assertEquals(2,dao.getEvaluatetion("如家酒店").size());
	}

}

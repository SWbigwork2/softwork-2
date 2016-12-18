package dao.evaluateTester;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

import Evaluateblimpl.ResultMessage;
import data.dao.EvaluateDao;
import data.dao.impl.EvaluateDaoImpl;
import po.EvaluatePO;

public class EvaluateDataTester {

	@Test
	public void addEvalaute() {
		EvaluatePO evaluatePO=new EvaluatePO("金陵饭店", 4.3, "good","李华");
	   EvaluateDao dao=EvaluateDaoImpl.getInstance();
		ResultMessage reusltMessage=ResultMessage.success;
		try {
			assertEquals(reusltMessage,dao.addEvaluate(evaluatePO));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getEvalaute() {
		 EvaluateDao dao=EvaluateDaoImpl.getInstance();
		try {
			assertEquals(2,dao.getEvaluatetion("如家酒店").size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

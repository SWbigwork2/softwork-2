package data.evaluateTester;

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
			assertEquals(3,dao.getEvaluatetion("南京夜泊秦淮君亭酒店").size());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void getScoreTEst(){
		EvaluateDao dao=new EvaluateDaoImpl();
		try {
			assertEquals(4, (int)dao.getScore("南京夜泊秦淮君亭酒店"));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

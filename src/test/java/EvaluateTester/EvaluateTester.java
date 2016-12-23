package EvaluateTester;
import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Evaluateblimpl.EvaluateVO;
import Evaluateblimpl.Evaluateblimpl;
import Evaluateblimpl.ResultMessage;
import blservice.EvaluateService;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderType;
import po.EvaluatePO;
import vo.OrderVo;



public class EvaluateTester {
	
private RemoteHelper remoteHelper;
	
	public void linkToServer(){
		final String ip = "localhost";
		try{
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://"+ip+":8888/DateRemoteObject"));
			System.out.println("linked");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	    
	@Test
	public void evaluateTester(){
		this.linkToServer();
		Evaluateblimpl em=new Evaluateblimpl();	
		OrderVo orderVo=new OrderVo();
		orderVo.setOrderId(151916);
		orderVo.setType(OrderType.done.name());
		EvaluateVO evaluatePO=new EvaluateVO("如家",4,"good","哈哈");
		assertEquals(ResultMessage.success,em.evaluate(evaluatePO,orderVo));

	}
	
	@Test
	public void getListTest(){
		this.linkToServer();
		EvaluateService evaluateblimpl=new Evaluateblimpl();
		ArrayList<String > list=evaluateblimpl.getComments("金陵饭店");
		assertEquals(1, list.size());
	}
	
	@Test
	public void getScore(){
		this.linkToServer();
		EvaluateService evaluateService=new Evaluateblimpl();
		System.out.println(evaluateService.getScore("南京夜泊秦淮君亭酒店"));
		assertEquals(2, (int)evaluateService.getScore("南京夜泊秦淮君亭酒店"));
	}
}

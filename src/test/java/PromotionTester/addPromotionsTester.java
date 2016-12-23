package PromotionTester;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import Promotionsblimpl.PromotionsServiceImpl;
import blservice.PromotionsService;
import data.rmi.RemoteHelper;
import view.staff.PromotionsIVO;

public class addPromotionsTester {
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
public void addPromotionsTester(){
	PromotionsIVO promotionsIVO=new PromotionsIVO(1, "七天", "生日特惠打五折", 0.5);
	PromotionsService promotionsService=new PromotionsServiceImpl();
	assertTrue(promotionsService.addPromotionsI(promotionsIVO));
	
}


}

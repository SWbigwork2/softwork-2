package rmiTest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.rmi.RemoteHelper;

public class linkTest {
	private RemoteHelper remoteHelper;
	public linkTest(){
		linkToServer();
	}
	public void linkToServer(){
		try{
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://localhost:8888/DateRemoteObject"));
			System.out.println("linked");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	public void test(){
		System.out.println(remoteHelper.getOrdersDao().getOrderList("1000").size());
	}
	public static void main(String[] args) {
		linkTest test = new linkTest();
	test.test();
	}

}


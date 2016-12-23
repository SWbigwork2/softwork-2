package HotelTester;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Test;

import Hotelblimpl.HotelServiceImpl;
import blservice.HotelService;
import data.rmi.RemoteHelper;

public class HotelTest {
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
	public void test() {
		linkToServer();
		HotelService hotelService = new HotelServiceImpl();
		assertTrue(hotelService.judgeHotelExists("南京金丝利喜来登酒店"));
	}

}

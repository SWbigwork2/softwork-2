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
import vo.HotelVo;

public class HotelTest {
	
	public void linkToServer(){
		final String ip = "localhost";
		try{
			RemoteHelper remoteHelper = RemoteHelper.getInstance();
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
	public void test1(){
		HotelService hotelService = new HotelServiceImpl();
		HotelVo hotelVo = hotelService.getHotelInfo("金陵饭店");
		assertEquals(hotelVo.getName(),"金陵饭店");
		
	}
	
	@Test
	public void test2(){
		HotelService hotelService = new HotelServiceImpl();
		assertTrue(hotelService.judgeHotelExists("金陵饭店"));
	}
}

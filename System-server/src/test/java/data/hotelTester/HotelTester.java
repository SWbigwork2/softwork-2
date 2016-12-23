package data.hotelTester;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.HotelsDao;
import data.dao.impl.HotelsDaoImpl;
import po.HotelPO;

public class HotelTester {

	HotelPO hotelPO;

	@Test
	public void getHotel() throws RemoteException {
		HotelsDao hotelsDao = new HotelsDaoImpl();
		hotelPO = hotelsDao.getHotelDetails("金陵饭店");
		assertEquals("汉中路169号", hotelPO.getAddress());
	}

	@Test
	public void getHotelList() throws RemoteException {
		HotelsDao hotelsDao = new HotelsDaoImpl();
		ArrayList<HotelPO> list = hotelsDao.getHotelList(hotelPO);
		assertEquals(list.size(), 1);
	}

}

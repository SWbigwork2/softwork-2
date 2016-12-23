package data.roomTester;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import data.dao.RoomsDao;
import data.dao.impl.RoomsDaoImpl;

public class RoomTester {
	
	@Test
	public void checkOutTester() throws RemoteException{
		RoomsDao roomsDao = new RoomsDaoImpl();
		Date StartTime = new Date(116,11,20);
		Date  EndTime = new Date(116,11,23);
		roomsDao.recordReservation(1101, StartTime, EndTime, 111111);
		roomsDao.recordCheckOut(1101, 111111);
		assertEquals(roomsDao.getOrderRoom(111111),0);
		
	}
	

	@Test
	public void checkInTester() throws RemoteException{
		RoomsDao roomsDao = new RoomsDaoImpl();
		Date StartTime = new Date(116,11,20);
		Date  EndTime = new Date(116,11,23);
		roomsDao.recordReservation(1101, StartTime, EndTime, 111111);
		roomsDao.recordCheckIn(1101, 111111, StartTime);
		assertEquals(roomsDao.getOrderRoom(111111),0);
		
	}

}

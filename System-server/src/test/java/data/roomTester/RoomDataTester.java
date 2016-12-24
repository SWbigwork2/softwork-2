package data.roomTester;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;
import org.junit.Test;
import data.dao.RoomsDao;
import data.dao.impl.RoomsDaoImpl;
import po.RoomPO;

public class RoomDataTester {
	
	@Test
	public void searchForRoomTest() throws RemoteException{
		RoomsDao roomsDao = new RoomsDaoImpl();
		ArrayList<RoomPO> roomList = roomsDao.getRoomList("金陵饭店");
		assertEquals(roomList.size(),15);
	}
}

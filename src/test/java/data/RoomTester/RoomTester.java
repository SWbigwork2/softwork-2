package data.RoomTester;
import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Test;

import RoomsMock.RoomType;
import data.dao.RoomsDao;
import data.dao.impl.RoomsDaoImpl;
import po.RoomPO;

public class RoomTester {
	
	@Test
	public void getListTest(){
		RoomsDao roomsDao = RoomsDaoImpl.getInstance();
		RoomPO roomPO1 = new RoomPO("301","金陵饭店",RoomType.big,"舒适",999.0,null);
		RoomPO roomPO2 = new RoomPO("502","金陵饭店",RoomType.big,"舒适",999.0,null);
		
		roomsDao.insertRoom(roomPO1);
		roomsDao.insertRoom(roomPO2);
		ArrayList <RoomPO> roomList = roomsDao.getRoomList("金陵饭店");
		for(RoomPO cell:roomList){
			assertEquals(cell.getPrice(),999.0,0.001);
		}
		roomsDao.deleteRoom("301");
		roomsDao.deleteRoom("502");
	}
	
	@Test
	public void recordStartTimeTest(){
		RoomsDao roomsDao = RoomsDaoImpl.getInstance();
		RoomPO roomPO1 = new RoomPO("301","金陵饭店",RoomType.big,"舒适",999.0,null);
		
		roomsDao.insertRoom(roomPO1);
		
		Timestamp startTime = new Timestamp(116,10,30,8,30,00,00);
		Timestamp endTime = new Timestamp(116,10,31,8,30,00,00);
		roomsDao.recordStartTime("301", startTime, endTime);
		ArrayList <RoomPO> roomList = roomsDao.getRoomList("金陵饭店");
		for(RoomPO cell:roomList){
			assertEquals(cell.getRoomStatus().get(0),startTime);
			assertEquals(cell.getRoomStatus().get(1),endTime);
		}
		roomsDao.deleteRoom("301");
	}
	
	@Test
	public void recordCheckOutTest(){
		RoomsDao roomsDao = RoomsDaoImpl.getInstance();
		RoomPO roomPO1 = new RoomPO("301","金陵饭店",RoomType.big,"舒适",999.0,null);
		
		roomsDao.insertRoom(roomPO1);
		Timestamp startTime1 = new Timestamp(116,10,30,8,30,00,00);
		Timestamp endTime1 = new Timestamp(116,10,31,8,30,00,00);
		roomsDao.recordStartTime("301", startTime1, endTime1);
		
		Timestamp startTime2 = new Timestamp(116,11,30,8,30,00,00);
		Timestamp endTime2 = new Timestamp(116,11,31,8,30,00,00);
		roomsDao.recordStartTime("301", startTime2, endTime2);
		
		Timestamp startTime3 = new Timestamp(116,12,30,8,30,00,00);
		Timestamp endTime3= new Timestamp(116,12,31,8,30,00,00);
		roomsDao.recordStartTime("301", startTime3, endTime3);
		
		roomsDao.recordCheckOut("301", startTime2);
		ArrayList <RoomPO> roomList = roomsDao.getRoomList("金陵饭店");
		for(RoomPO cell:roomList){
			assertEquals(cell.getRoomStatus().get(0),startTime1);
			assertEquals(cell.getRoomStatus().get(1),endTime1);
			assertEquals(cell.getRoomStatus().get(2),startTime3);
			assertEquals(cell.getRoomStatus().get(3),endTime3);
		}
		roomsDao.deleteRoom("301");
	}

}

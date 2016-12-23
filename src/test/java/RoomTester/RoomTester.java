package RoomTester;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import Roomblimpl.RoomServiceImpl;
import blservice.RoomService;

public class RoomTester {
	
	@Test
	public void getHighestTest(){
		RoomService roomService = new RoomServiceImpl();
		Date startTime = new Date(116,11,20);
		Date endTime = new Date(116,11,21);
		double highPrice = roomService.getHighestPrice("金陵饭店", startTime, endTime);
		double lowPrice = roomService.getLowestPrice("金陵饭店", startTime, endTime);
		assertTrue(highPrice>lowPrice);
		
	}
	
	@Test
	public void getRoomNumTest(){
		RoomService roomService = new RoomServiceImpl();
		Date startTime = new Date(116,11,20);
		Date endTime = new Date(116,11,21);
		int k = roomService.numberOfAllRooms("金陵饭店", startTime, endTime);
		assertEquals(k, 15);
	}

}

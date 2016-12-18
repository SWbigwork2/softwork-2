package data.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import data.dao.RoomsDao;
import data.dataHelper.DataFactory;
import data.dataHelper.RoomsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.RoomPO;

public class RoomsDaoImpl implements RoomsDao {

	private static RoomsDaoImpl roomsDaoImpl;

	private RoomsDataHelper roomsDataHelper;

	private DataFactory dataFactory;
	
	public static RoomsDaoImpl getInstance() {
		// 单例模式：只有一个RoomsDaoImpl
		if (roomsDaoImpl == null) {
			roomsDaoImpl = new RoomsDaoImpl();
			return roomsDaoImpl;
		} else {
			return roomsDaoImpl;
		}
	}

	public RoomsDaoImpl() {
		dataFactory = new DataFactoryImpl();
		roomsDataHelper = dataFactory.getRoomsDataHelper();
	}

	public ArrayList<RoomPO> getRoomList(String hotelName) {
		ArrayList<RoomPO> roomsList = roomsDataHelper.getRoomList(hotelName);
		System.out.println(roomsList.size());
		return roomsList;
	}

	public boolean insertRoom(RoomPO roomPO) {
		boolean insert = roomsDataHelper.insertRoom(roomPO);
		return insert;
	}


	public boolean recordReservation(int roomID, Date StartTime, Date EndTime,int orderId) {
		boolean recordStart = roomsDataHelper.recordReservation(roomID, StartTime, EndTime, orderId);
		return recordStart;
	}

	public boolean recordCheckOut(int roomID, int orderId) {
		boolean recordCheckOut = roomsDataHelper.recordCheckOut(roomID, orderId);
		return recordCheckOut;
	}

	@Override
	public ArrayList<Integer> getOrderRoom(int orderId) {
		ArrayList<Integer> list = roomsDataHelper.getOrderRoom(orderId);
		return list;
	}

	public boolean recordOrderRoom(int orderId, ArrayList<Integer> roomIdList){
		boolean record = roomsDataHelper.recordOrderRoom(orderId, roomIdList);
		return record;
	}

	@Override
	public boolean recordCheckIn(int roomID, int orderId, Date StartTime) {
		boolean record = roomsDataHelper.recordCheckIn(roomID, orderId, StartTime);
		return record;
	}

	
}

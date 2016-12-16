package data.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import data.dataHelper.DataFactory;
import data.dataHelper.RoomsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataservice.RoomsDao;
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

	public boolean deleteRoom(String roomID) {
		boolean delete = roomsDataHelper.deleteRoom(roomID);
		return delete;
	}

	public boolean updateRoom(RoomPO roomPO) {
		boolean update = roomsDataHelper.updateRoom(roomPO);
		return update;
	}

	public boolean recordStartTime(String roomID, Date StartTime, Date EndTime) {
		boolean recordStart = roomsDataHelper.recordStartTime(roomID, StartTime, EndTime);
		return recordStart;
	}

	public boolean recordCheckOut(String roomID, Date StartTime) {
		boolean recordCheckOut = roomsDataHelper.recordCheckOut(roomID, StartTime);
		return recordCheckOut;
	}

}

package data.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import data.dao.RoomsDataService;
import data.dataHelper.DataFactory;
import data.dataHelper.RoomsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import data.dataservice.RoomsDao;
import data.rmi.RemoteHelper;
import po.RoomPO;

public class RoomsDaoImpl implements RoomsDataService {

	private static RoomsDaoImpl roomsDaoImpl;

	private RoomsDataHelper roomsDataHelper;

	private DataFactory dataFactory;
	private RemoteHelper remoteHelper;
	private RoomsDao roomsDao;
	
	

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
		remoteHelper = RemoteHelper.getInstance();
		roomsDao = remoteHelper.getRoomsDao();
		dataFactory = new DataFactoryImpl();
		roomsDataHelper = dataFactory.getRoomsDataHelper();
	}

	public ArrayList<RoomPO> getRoomList(String hotelName) {
		/*ArrayList<RoomPO> roomsList = roomsDataHelper.getRoomList(hotelName);
		System.out.println(roomsList.size());
		return roomsList;*/
		return roomsDao.getRoomList(hotelName);
	}

	public boolean insertRoom(RoomPO roomPO) {
		/*boolean insert = roomsDataHelper.insertRoom(roomPO);
		return insert;*/
		return roomsDao.insertRoom(roomPO);
	}

	public boolean deleteRoom(String roomID) {
		/*
		boolean delete = roomsDataHelper.deleteRoom(roomID);
		return delete;*/
		return roomsDao.deleteRoom(roomID);
	}

	public boolean updateRoom(RoomPO roomPO) {
		/*
		boolean update = roomsDataHelper.updateRoom(roomPO);
		return update;*/
		return roomsDao.updateRoom(roomPO);
	}

	public boolean recordStartTime(String roomID, Date StartTime, Date EndTime) {
		/*
		boolean recordStart = roomsDataHelper.recordStartTime(roomID, StartTime, EndTime);
		return recordStart;*/
		return roomsDao.recordStartTime(roomID, StartTime, EndTime);
	}

	public boolean recordCheckOut(String roomID, Date StartTime) {
		/*
		boolean recordCheckOut = roomsDataHelper.recordCheckOut(roomID, StartTime);
		return recordCheckOut;*/
		return roomsDao.recordCheckOut(roomID, StartTime);
	}

}

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
	
	public static void main(String[] args){
		RoomsDao roomsDataImpl = new RoomsDaoImpl();
		ArrayList <RoomPO> list=roomsDataImpl.getRoomList("金陵饭店");
		for(RoomPO cell:list){
			System.out.println(cell.getPrice());
		}
		
	}

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
		
		
		
		for (RoomPO cell : roomsList) {
			
			java.sql.Timestamp time1 = null;
			java.sql.Timestamp time2 = null;
			java.sql.Timestamp time3 = null;
			java.sql.Timestamp time4 = null;
			
			ArrayList<java.sql.Timestamp> timestampList = cell.getRoomStatus();
			if(timestampList.size()==2){
			time1 = timestampList.get(0);
			}else if(timestampList.size()==4){
			time1 = timestampList.get(0);
			time2 = timestampList.get(2);
			}else if(timestampList.size()==6){
			time1 = timestampList.get(0);
			time2 = timestampList.get(2);
			time3 = timestampList.get(4);
			}else if(timestampList.size()==8){
			time1 = timestampList.get(0);
			time2 = timestampList.get(2);
			time3 = timestampList.get(4);
			time4 = timestampList.get(6);
			}

			ArrayList<java.sql.Timestamp> newTimeList = new ArrayList<java.sql.Timestamp>();

			if (time1 != null) {
				newTimeList.add(time1);
				newTimeList.add(timestampList.get(1));
			}
			if (time2 != null) {
				newTimeList.add(time2);
				newTimeList.add(timestampList.get(3));
			}
			if (time3 != null) {
				newTimeList.add(time3);
				newTimeList.add(timestampList.get(5));
			}
			if (time4 != null) {
				newTimeList.add(time4);
				newTimeList.add(timestampList.get(7));
			}
			cell.setPeriod(newTimeList);
		}
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

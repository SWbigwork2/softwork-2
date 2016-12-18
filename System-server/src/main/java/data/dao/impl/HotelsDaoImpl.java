package data.dao.impl;

import java.util.ArrayList;

import data.dao.HotelsDao;
import data.dataHelper.DataFactory;
import data.dataHelper.HotelsDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.HotelPO;
import po.RoomPO;

public class HotelsDaoImpl implements HotelsDao {
	
	private static HotelsDaoImpl hotelsDaoImpl;

	private HotelsDataHelper hotelsDataHelper;

	private DataFactory dataFactory;


	public static HotelsDaoImpl getInstance() {
		// 单例模式：只有一个HotelsDaoImpl
		if (hotelsDaoImpl == null) {
			hotelsDaoImpl = new HotelsDaoImpl();
		}
		return hotelsDaoImpl;
	}

	public HotelsDaoImpl() {
			dataFactory = new DataFactoryImpl();
			hotelsDataHelper = dataFactory.getHotelsDataHelper();
	}
	
	//实际查询过程中需要得到该酒店的房间信息，并根据房间信息进行进一步筛选，此过程仅得到酒店名称 地址 商圈符合条件的酒店列表
	public ArrayList<HotelPO> getHotelList(HotelPO hotelPO) {
		ArrayList <HotelPO> hotelPOList = hotelsDataHelper.getHotelList(hotelPO);
		return hotelPOList;
	}

	public HotelPO getHotelDetails(String hotelName) {
		HotelPO detailHotelPO = hotelsDataHelper.getHotelDetail(hotelName);
		return detailHotelPO;
	}

	public boolean insertHotel(HotelPO hotelPO) {
		boolean insert = hotelsDataHelper.insertHotel(hotelPO);
		return insert;
	}

	public boolean deleteHotel(String hotelName) {
		boolean delete = hotelsDataHelper.deleteHotel(hotelName);
		return delete;
	}

	public boolean updateHotel(HotelPO hotelPO) {
		boolean update = hotelsDataHelper.updateHotel(hotelPO);
		return update;
	}
	
	public ArrayList<RoomPO> getRoomOfHotel(String hotelName){
		ArrayList<RoomPO> roomList = hotelsDataHelper.getRoomOfHotel(hotelName);
		return roomList;
	}
	
	public boolean judgeHotelExists(String hotelName){
		boolean hotelExists = hotelsDataHelper.judgeHotelExists(hotelName);
		return hotelExists;
	}

}

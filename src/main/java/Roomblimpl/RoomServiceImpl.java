package Roomblimpl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import blservice.RoomService;
import data.dao.RoomsDao;
import data.dao.impl.RoomsDaoImpl;
import po.RoomPO;
import view.member.RoomVo;

public class RoomServiceImpl implements RoomService {

	private RoomsDao roomsDao = RoomsDaoImpl.getInstance();
	private RoomVoPoTran roomVoPoTran = new RoomVoPoTran();
	
	/**
	 * 用于记录当下入住的房间，房间号与实际入住时间对应
	 */
	private static Map<String,Date> presentUnavailableRooms = new HashMap<String, Date>();
	/**
	 * 用于记录订单与该订单的房间号的对应，一张订单可以预定多间房间，因此一个代表订单号的String键值
	 * 对应一个包含本次预定所有房间号的数组
	 */
	private static Map<String, ArrayList<String>> orderRoomList = new HashMap<>();
	/**
	 * 用于记录订单号与预定入住时间的对应
	 */
	private static Map<String, Date> resvervationList = new HashMap<String,Date>();


	/**
	 * @param ArrayList<RoomVo>
	 */
	@Override
	public void addNewRoom(ArrayList<RoomVo> roomList) {
		for (RoomVo cell : roomList) {
			roomsDao.insertRoom(roomVoPoTran.VoToPo(cell));
		}
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<RoomVo> getRoomOfHotel(String hotelName, Date startTime, Date endTime) {
		
		ArrayList<RoomPO> roomList = roomsDao.getRoomList(hotelName);
		boolean[] isAvailable = new boolean[roomList.size()];
		for (int k = 0; k < isAvailable.length; k++) {
			isAvailable[k] = true;
		}
		int i = 0;
		for (RoomPO cell : roomList) {
			Map<Date, Date> timePeriod = cell.getUnavailablePeriod();
			if (timePeriod != null) {
				Set<Date> startTimeList = timePeriod.keySet();
				for (Date dateCell : startTimeList) {
					if (!(  endTime.before(dateCell)  ||  endTime.equals(dateCell)   ||   startTime.after(timePeriod.get(dateCell))  ||  startTime.equals(timePeriod.get(dateCell))  )) {
						isAvailable[i] = false;
						break;
					}
				}
			}
			i++;
		}

		ArrayList<RoomVo> resultList = new ArrayList<RoomVo>();
		int j = 0;
		for (boolean cell : isAvailable) {
			if (cell) {
				resultList.add(roomVoPoTran.PoToVO(roomList.get(j)));
			}
			j++;
		}
		return resultList;
	}

	/**
	 * 
	 */
	@Override
	public void makeReservation(String orderId,String hotelName, RoomType roomType, Date startTime, Date endTime, int roomNum) {
		ArrayList<RoomVo> hotelList = getRoomOfHotel(hotelName, startTime, endTime);
		ArrayList<String> roomNameList = new ArrayList<String>();
		for (RoomVo cell : hotelList) {
			if (cell.getRoomType().equals(roomType)) {
				roomNameList.add(cell.getRoomId());
			}
		}
		ArrayList<String> roomList = new ArrayList<String>();
		ArrayList<Date> dateList = new ArrayList<>();
		dateList.add(startTime);
		for (int i = 0; i < roomNum; i++) {
			roomsDao.recordStartTime(roomNameList.get(i), startTime, endTime);
			roomList.add(roomNameList.get(i));
		}
		orderRoomList.put(orderId, roomList);
		resvervationList.put(orderId, startTime);
	}
	
	/**
	 * 
	 */
	@Override
	public void makeCheckIn(String orderId,Date startTime){
		ArrayList<String> list = orderRoomList.get(orderId);
		for(String cell:list){
			presentUnavailableRooms.put(cell,startTime);
		}
	}
	

	/**
	 * 
	 */
	@Override
	public void makeCheckOut(String orderId,String roomId, Date endTime) {
		Date startTime = resvervationList.get(roomId);
		roomsDao.recordCheckOut(roomId, startTime);
		presentUnavailableRooms.remove(roomId);
	}

	/**
	 * 
	 */
	@Override
	public double getHighestPrice(String hotelName, Date startTime, Date endTime) {
		Map<RoomType, Double> PriceOfType = getPriceOfRoom(hotelName, startTime, endTime);
		double price1 = PriceOfType.get(RoomType.单人间);
		double price2 = PriceOfType.get(RoomType.商务间);
		double price3 = PriceOfType.get(RoomType.标准间);
		double price4 = PriceOfType.get(RoomType.行政标准间);
		double price5 = PriceOfType.get(RoomType.高级套间);

		ArrayList<Double> list = new ArrayList<Double>();
		list.add(price1);
		list.add(price2);
		list.add(price3);
		list.add(price4);
		list.add(price5);

		double highest = price1;
		for (int i = 0; i <= 4; i++) {
			if (highest < list.get(i)) {
				highest = list.get(i);
			}
		}
		return highest;
	}

	/**
	 * 
	 */
	@Override
	public double getLowestPrice(String hotelName, Date startTime, Date endTime) {
		Map<RoomType, Double> PriceOfType = getPriceOfRoom(hotelName, startTime, endTime);
		double price1 = PriceOfType.get(RoomType.单人间);
		double price2 = PriceOfType.get(RoomType.商务间);
		double price3 = PriceOfType.get(RoomType.标准间);
		double price4 = PriceOfType.get(RoomType.行政标准间);
		double price5 = PriceOfType.get(RoomType.高级套间);

		ArrayList<Double> list = new ArrayList<Double>();
		list.add(price1);
		list.add(price2);
		list.add(price3);
		list.add(price4);
		list.add(price5);

		double lowest = price1;
		for (int i = 0; i <= 4; i++) {
			if (lowest > list.get(i)) {
				lowest = list.get(i);
			}
		}
		return lowest;
	}

	/**
	 * 
	 */
	@Override
	public int numberOfAllRooms(String hotelName, Date startTime, Date endTime) {
		Map<RoomType, Integer> numOfRoom = getNumOfRoom(hotelName, startTime, endTime);
		return (numOfRoom.get(RoomType.单人间) + numOfRoom.get(RoomType.商务间) + numOfRoom.get(RoomType.标准间)
				+ numOfRoom.get(RoomType.行政标准间) + numOfRoom.get(RoomType.高级套间));
	}

	/**
	 * 
	 */
	@Override
	public ArrayList<RoomType> getHotelRoomType(String hotelName, Date startTime, Date endTime) {
		Map<RoomType, Integer> numOfRoom = getNumOfRoom(hotelName, startTime, endTime);
		ArrayList<RoomType> list = new ArrayList<RoomType>();
		if (numOfRoom.get(RoomType.单人间) != 0) {
			list.add(RoomType.单人间);
		}
		if (numOfRoom.get(RoomType.商务间) != 0) {
			list.add(RoomType.商务间);
		}
		if (numOfRoom.get(RoomType.标准间) != 0) {
			list.add(RoomType.标准间);
		}
		if (numOfRoom.get(RoomType.行政标准间) != 0) {
			list.add(RoomType.行政标准间);
		}
		if (numOfRoom.get(RoomType.高级套间) != 0) {
			list.add(RoomType.高级套间);
		}
		return list;
	}

	/**
	 * 
	 */
	@Override
	public Map<RoomType, Double> getPriceOfRoom(String hotelName, Date startTime, Date endTime) {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomList = roomService.getRoomOfHotel(hotelName, startTime, endTime);
		/**
		 * priceType1指的是单人间 priceType2指的是商务间 priceType3指的是标准间 priceType4指的是行政标准间
		 * priceType5指的是高级套间
		 */
		double priceType1 = 0;
		double priceType2 = 0;
		double priceType3 = 0;
		double priceType4 = 0;
		double priceType5 = 0;

		for (RoomVo cell : roomList) {
			switch (cell.getRoomType()) {
			case 单人间:
				priceType1 = cell.getRoomPrice();
			case 商务间:
				priceType2 = cell.getRoomPrice();
			case 标准间:
				priceType3 = cell.getRoomPrice();
			case 行政标准间:
				priceType4 = cell.getRoomPrice();
			case 高级套间:
				priceType5 = cell.getRoomPrice();
			}
		}

		Map<RoomType, Double> PriceOfType = new HashMap<RoomType, Double>();
		PriceOfType.put(RoomType.单人间, priceType1);
		PriceOfType.put(RoomType.商务间, priceType2);
		PriceOfType.put(RoomType.标准间, priceType3);
		PriceOfType.put(RoomType.行政标准间, priceType4);
		PriceOfType.put(RoomType.高级套间, priceType5);

		return PriceOfType;

	}

	/**
	 * 
	 */
	@Override
	public Map<RoomType, Integer> getNumOfRoom(String hotelName, Date startTime, Date endTime) {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomList = roomService.getRoomOfHotel(hotelName, startTime, endTime);

		/**
		 * roomType1指的是单人间 roomType2指的是商务间 roomType3指的是标准间 roomType4指的是行政标准间
		 * roomType5指的是高级套间
		 */
		int roomType1 = 0;
		int roomType2 = 0;
		int roomType3 = 0;
		int roomType4 = 0;
		int roomType5 = 0;

		for (RoomVo cell : roomList) {
			switch (cell.getRoomType()) {
			case 单人间:
				roomType1++;
			case 商务间:
				roomType2++;
			case 标准间:
				roomType3++;
			case 行政标准间:
				roomType4++;
			case 高级套间:
				roomType5++;
			}
		}
		Map<RoomType, Integer> numOfRoomType = new HashMap<RoomType, Integer>();
		numOfRoomType.put(RoomType.单人间, roomType1);
		numOfRoomType.put(RoomType.商务间, roomType2);
		numOfRoomType.put(RoomType.标准间, roomType3);
		numOfRoomType.put(RoomType.行政标准间, roomType4);
		numOfRoomType.put(RoomType.高级套间, roomType5);

		return numOfRoomType;
	}
}
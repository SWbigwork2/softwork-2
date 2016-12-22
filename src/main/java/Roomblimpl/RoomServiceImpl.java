package Roomblimpl;

import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import blservice.OrdersService;
import blservice.RoomService;
import data.dao.RoomsDao;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import po.RoomPO;
import view.member.RoomVo;

public class RoomServiceImpl implements RoomService {

	private RoomsDao roomsDao;
	private RemoteHelper remoteHelper;
	private RoomVoPoTran roomVoPoTran = new RoomVoPoTran();
	private OrdersService ordersService = new OrderServiceImpl();
	
	public RoomServiceImpl() {
		remoteHelper = RemoteHelper.getInstance();
		roomsDao = remoteHelper.getRoomsDao();
		// TODO Auto-generated constructor stub
	}
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
                    if (!((endTime.before(dateCell) || endTime.equals(dateCell)
                           || startTime.after(timePeriod.get(dateCell))
                           || startTime.equals(timePeriod.get(dateCell))))) {
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
	public void makeReservation(int orderId, String hotelName, RoomType roomType, Date startTime, Date endTime,
			int roomNum) {

		ArrayList<RoomVo> hotelList = getRoomOfHotel(hotelName, startTime, endTime);
		ArrayList<Integer> roomNameList = new ArrayList<Integer>();
		for (RoomVo cell : hotelList) {
			if (cell.getRoomType().equals(roomType)) {
				roomNameList.add(cell.getRoomId());
			}
		}

		for (int i = 0; i < roomNum; i++) {
			roomsDao.recordReservation(roomNameList.get(i), startTime, endTime, orderId);
		}
		roomsDao.recordOrderRoom(orderId, roomNameList);
	}

	/**
	 * 
	 */
	@Override
	public void makeCheckIn(int orderId, Date startTime) {
		ArrayList<Integer> roomList = roomsDao.getOrderRoom(orderId);
		for (Integer cell : roomList) {
			roomsDao.recordCheckIn(cell, orderId, startTime);
			ordersService.recordIn(orderId, startTime);
		}
	}

	/**
	 * 
	 */
	@Override
	public void makeCheckOut(int orderId, int roomId, Date endTime) {
		roomsDao.recordCheckOut(roomId, orderId);
		ordersService.recordOut(orderId, endTime);
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
        ArrayList<RoomPO> roomList = roomsDao.getRoomList(hotelName);
        /**
         * priceType1指的是单人间 priceType2指的是商务间 priceType3指的是标准间 priceType4指的是行政标准间
         * priceType5指的是高级套间
         */
        double priceType1 = 0;
        double priceType2 = 0;
        double priceType3 = 0;
        double priceType4 = 0;
        double priceType5 = 0;
        
        for (RoomPO cell : roomList) {
            switch (cell.getRoomType()) {
                case 单人间:
                    priceType1 = cell.getPrice();
                    break;
                case 商务间:
                    priceType2 = cell.getPrice();
                    break;
                case 标准间:
                    priceType3 = cell.getPrice();
                    break;
                case 行政标准间:
                    priceType4 = cell.getPrice();
                    break;
                case 高级套间:
                    priceType5 = cell.getPrice();
                    break;
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
                break;
			case 商务间:
				roomType2++;
                break;
			case 标准间:
				roomType3++;
                break;
			case 行政标准间:
				roomType4++;
                break;
			case 高级套间:
				roomType5++;
                break;
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
	
	@Override
	public void revokeReservatio(int orderId) {
		ArrayList<Integer> roomIdList = roomsDao.getOrderRoom(orderId);
		for(int cell:roomIdList){
			roomsDao.recordCheckOut(cell, orderId);
		}
		
	}
	
	
}

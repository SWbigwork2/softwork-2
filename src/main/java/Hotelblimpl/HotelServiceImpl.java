package Hotelblimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.HotelService;
import blservice.RoomService;
import data.dao.HotelsDao;
import data.dao.impl.HotelsDaoImpl;
import po.HotelPO;
import view.member.HotelColumnVo;
import view.member.HotelSearchVo;
import view.member.RoomVo;
import vo.HotelVo;

public class HotelServiceImpl implements HotelService {

	private static Map<String, Double> HotelNameAndRemarkList = new HashMap<String, Double>();
	private static Map<String, Integer> HotelRemarkList = new HashMap<String, Integer>();
	private static ArrayList<String> hotelNameList = new ArrayList<String>();

	HotelsDao hotelsDao = HotelsDaoImpl.getInstance();
	HotelVoPoTran hotelVoPoTran = new HotelVoPoTran();
	/**
	 * 调用数据层接口得到酒店信息，该信息中并不包含房间信息
	 */
	@Override
	public HotelVo getHotelInfo(String hotelName) {
		return hotelVoPoTran.PoToVo(hotelsDao.getHotelDetails(hotelName));
	}
	/**
	 * 依赖Room类得到该酒店在某一时段的房间信息列表
	 */
	@Override
	public ArrayList<RoomVo> getRoomOfHotel(String hotelName, Date startTime, Date endTime) {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomVoList = roomService.getRoomOfHotel(hotelName, startTime, endTime);
		return roomVoList;
	}

	/**
	 * 提供给评价类用于设置酒店评分的方法
	 */
	@Override
	public void setHotelRemark(String hotelName, int hotelRemark) {
		int remarkNumber = HotelRemarkList.get(hotelName);
		double previousRemark = HotelNameAndRemarkList.get(hotelName);
		double newRemark = (previousRemark*remarkNumber+hotelRemark)/(remarkNumber+1);
		HotelNameAndRemarkList.replace(hotelName, previousRemark, newRemark);
		HotelRemarkList.replace(hotelName, remarkNumber, remarkNumber+1);
	}
	/**
	 * 调用评价类的方法得到酒店评价列表
	 */
	@Override
	public ArrayList<String> getHotelComment(String hotelName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 高级搜索酒店
	 * 可以通过酒店名称、房间（类型、原始价格区间、有空房期间（房间数量、入住日期，退房日期））
	 * 星级、评分区间等条件进行搜索，这些条件可以独立起作用，也可以联合起作用 
	 * 
	 */
	@Override
	public ArrayList<HotelColumnVo> getHotelListInfo(HotelSearchVo hotelSearchVo) {

		RoomService roomService = new RoomServiceImpl();

		LocalDate startTime = hotelSearchVo.getInTime();
		LocalDate endTime = hotelSearchVo.getOutTime();

		Date startTimestamp = Date.valueOf(startTime);
		Date endTimestamp = Date.valueOf(endTime);

		// 查询商圈 地址 酒店名称
		HotelPO hotelPO = null;
		if (hotelSearchVo.getHotelName() == "") {
			hotelPO = new HotelPO(null, hotelSearchVo.getHotelAddress(), hotelSearchVo.getTradeArea(), null, null,
					null);
		} else {
			hotelPO = new HotelPO(hotelSearchVo.getHotelName(), hotelSearchVo.getHotelAddress(),
					hotelSearchVo.getTradeArea(), null, null, null);
		}
		ArrayList<HotelPO> hotelList = hotelsDao.getHotelList(hotelPO);
		ArrayList<HotelPO> checkList = new ArrayList<HotelPO>();

		// 查询酒店等级
		HotelRanking hotelRanking = hotelSearchVo.getHotelRanking();
		if (hotelRanking != null) {
			for (HotelPO cell : hotelList) {
				if (cell.getRanking().equals(hotelRanking)) {
					checkList.add(cell);
				}
			}
			hotelList = checkList;
			checkList.clear();
		}

		// 查询酒店价格区间
		String hotelName = null;
		double highPrice = hotelSearchVo.getHighPrice();
		double lowPrice = hotelSearchVo.getLowPrice();
		double highestPrice = 0;
		double lowestPrice = 0;
		if (highPrice != -1) {
			for (HotelPO cell : hotelList) {
				hotelName = cell.getName();
				highestPrice = roomService.getHighestPrice(hotelName, startTimestamp, endTimestamp);
				lowestPrice = roomService.getLowestPrice(hotelName, startTimestamp, endTimestamp);
				if ((lowestPrice <= lowPrice) && (highestPrice >= highPrice)) {
					checkList.add(cell);
				}
			}
			hotelList = checkList;
			checkList.clear();
		}

		// 查询空房数量
		int numOfRoomsNeeded = hotelSearchVo.getNumOfNeededRooms();
		for (HotelPO cell : hotelList) {
			if (roomService.numberOfAllRooms(hotelName, startTimestamp, endTimestamp) >= numOfRoomsNeeded) {
				checkList.add(cell);
			}
		}
		hotelList = checkList;
		checkList.clear();

		// 查询房间类型
		RoomType roomType = hotelSearchVo.getRoomType();
		if (roomType != null) {
			for (HotelPO cell : hotelList) {
				if (roomService.getHotelRoomType(hotelName, startTimestamp, endTimestamp).contains(roomType)) {
					checkList.add(cell);
				}
			}
			hotelList = checkList;
			checkList.clear();
		}

		ArrayList<HotelColumnVo> hotelVoList = new ArrayList<HotelColumnVo>();
		for (HotelPO cell : hotelList) {
			hotelVoList.add(new HotelColumnVo(cell.getName(), roomService.getLowestPrice(cell.getName(), startTimestamp, endTimestamp),cell.getRanking(), getHotelRemark(cell.getName())));
		}
		return hotelVoList;
	}
	/**
	 * 维护酒店信息
	 */
	@Override
	public boolean updateHotel(HotelVo hotelVo) {
		return hotelsDao.updateHotel(hotelVoPoTran.VoToPo(hotelVo));
	}
	/**
	 * 判断酒店是否存在 通过维护酒店列表实现
	 */
	@Override
	public boolean judgeHotelExists(String hotelName) {
		boolean isExisted = false;

		for (String cell : hotelNameList) {
			if (cell.equals(hotelName)) {
				isExisted = true;
				break;
			}
		}
		return isExisted;
	}
	/**
	 * 添加一家新的酒店
	 */
	@Override
	public boolean addHotel(HotelVo hotelVo) {
		hotelNameList.add(hotelVo.getName());
		return hotelsDao.insertHotel(hotelVoPoTran.VoToPo(hotelVo));
	}
	/**
	 * 用于界面层调用取得酒店分数
	 */
	@Override
	public double getHotelRemark(String hotelName) {
		return 4.7;
		//return HotelNameAndRemarkList.get(hotelName);
	}
	
	@Override
	public HotelPO getHotelInformation(String hotelName) {
		return hotelsDao.getHotelDetails(hotelName);
	}

}

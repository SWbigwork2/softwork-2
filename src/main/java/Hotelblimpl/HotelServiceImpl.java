package Hotelblimpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;

import Evaluateblimpl.Evaluateblimpl;
import Roomblimpl.RoomServiceImpl;
import Roomblimpl.RoomType;
import blservice.EvaluateService;
import blservice.HotelService;
import blservice.OrdersService;
import blservice.RoomService;
import data.dao.HotelsDao;
import data.rmi.RemoteHelper;
import ordersblimpl.OrderServiceImpl;
import po.HotelPO;
import view.member.HotelColumnVo;
import view.member.HotelSearchVo;
import view.member.RoomVo;
import vo.HotelVo;

public class HotelServiceImpl implements HotelService {

	private RemoteHelper remoteHelper;
	private HotelsDao hotelsDao;
	HotelVoPoTran hotelVoPoTran = new HotelVoPoTran();
	private EvaluateService evaluateService = new Evaluateblimpl();
	public HotelServiceImpl() {
		remoteHelper = RemoteHelper.getInstance();
		hotelsDao = remoteHelper.getHotelsDao();

	}

	/**
	 * @param hotelName
	 * @return 得到酒店信息，该信息中并不包含房间信息
	 */
	@Override
	public HotelVo getHotelInfo(String hotelName) {
		return hotelVoPoTran.PoToVo(hotelsDao.getHotelDetails(hotelName));
	}

	/**
	 * @param hotelName startTime endTime
	 * @return 得到该酒店在某一时段的房间信息列表
	 */
	@Override
	public ArrayList<RoomVo> getRoomOfHotel(String hotelName, Date startTime, Date endTime) {
		RoomService roomService = new RoomServiceImpl();
		ArrayList<RoomVo> roomVoList = roomService.getRoomOfHotel(hotelName, startTime, endTime);
		return roomVoList;
	}

	/**
	 * @param hotelName
	 * @return 调用评价类的方法得到酒店评价列表
	 */
	@Override
	public ArrayList<String> getHotelComment(String hotelName) {
		EvaluateService evaluateService = new Evaluateblimpl();
		return evaluateService.getComments(hotelName);
	}

	/**
	 * @param hotelSearchVo
	 * @return 符合条件的酒店列表
	 * 高级搜索酒店 可以通过酒店名称、房间（类型、原始价格区间、有空房期间（房间数量、入住日期，退房日期））
	 * 星级、评分区间等条件进行搜索，这些条件可以独立起作用，也可以联合起作用
	 * 
	 */
    @Override
    public ArrayList<HotelColumnVo> getHotelListInfo(HotelSearchVo hotelSearchVo) {
        
        RoomService roomService = new RoomServiceImpl();
        
        LocalDate startTime = hotelSearchVo.getInTime();
        LocalDate endTime = hotelSearchVo.getOutTime();
        
        java.util.Date startTimestamp = new java.util.Date(java.sql.Date.valueOf(startTime).getTime());
        java.util.Date endTimestamp = new java.util.Date(java.sql.Date.valueOf(endTime).getTime());
        
        // 查询商圈 地址 酒店名称
        
        HotelPO hotelPO = null;
        if (hotelSearchVo.getHotelName() == "") {
            hotelPO = new HotelPO(null, hotelSearchVo.getHotelAddress(), hotelSearchVo.getTradeArea(), null, null,
                                  null);
        } else {
            hotelPO = new HotelPO(hotelSearchVo.getHotelName(), hotelSearchVo.getHotelAddress(),
                                  hotelSearchVo.getTradeArea(), null, null, null);
        }
        
        ArrayList<HotelPO> newHotelList = hotelsDao.getHotelList(hotelPO);
        ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
        if (hotelSearchVo.getIsHistorySearch()) {
            OrdersService ordersService = new OrderServiceImpl();
            ArrayList<String> hotelNameList = ordersService.getHotelList(hotelSearchVo.memberId());
            for(HotelPO cell:newHotelList){
                if(hotelNameList.contains(cell.getName())){
                    hotelList.add(cell);
                }
            }
        }else{
            for(HotelPO cell:newHotelList){
                hotelList.add(cell);
            }
        }
        
        // 查询酒店等级
        ArrayList<HotelPO> hotelList1 = new ArrayList<HotelPO>();
        HotelRanking hotelRanking = hotelSearchVo.getHotelRanking();
        if (hotelRanking != null) {
            for (HotelPO cell : hotelList) {
                if (cell.getRanking().equals(hotelRanking)) {
                    hotelList1.add(cell);
                }
            }
        } else {
            hotelList1.addAll(hotelList);
        }
        
        // 查询酒店价格区间
        ArrayList<HotelPO> hotelList2 = new ArrayList<HotelPO>();
        double highPrice = hotelSearchVo.getHighPrice();
        double lowPrice = hotelSearchVo.getLowPrice();
        if (highPrice != -1) {
            for (HotelPO cell : hotelList1) {
                Map<RoomType, Double> roomPriceMap = roomService.getPriceOfRoom(cell.getName(), startTimestamp, endTimestamp);
                double priceOfType1 = roomPriceMap.get(RoomType.单人间);
                double priceOfType2 = roomPriceMap.get(RoomType.商务间);
                double priceOfType3 = roomPriceMap.get(RoomType.标准间);
                double priceOfType4 = roomPriceMap.get(RoomType.行政标准间);
                double priceOfType5 = roomPriceMap.get(RoomType.高级套间);
                
                if(((highPrice>=priceOfType1)&&(lowPrice<=priceOfType1))||((highPrice>=priceOfType2)&&(lowPrice<=priceOfType2))||((highPrice>=priceOfType3)&&(lowPrice<=priceOfType3))||((highPrice>=priceOfType4)&&(lowPrice<=priceOfType4))||((highPrice>=priceOfType5)&&(lowPrice<=priceOfType5))){
                    hotelList2.add(cell);
                }
            }
        } else {
            hotelList2.addAll(hotelList1);
        }
        
        // 查询空房数量
        ArrayList<HotelPO> hotelList3 = new ArrayList<HotelPO>();
        int numOfRoomsNeeded = hotelSearchVo.getNumOfNeededRooms();
        
        RoomType roomType = hotelSearchVo.getRoomType();
        if (roomType != null) {
            for (HotelPO cell : hotelList2) {
                if (roomService.getNumOfRoom(cell.getName(), startTimestamp, endTimestamp)
                    .get(hotelSearchVo.getRoomType()) >= numOfRoomsNeeded) {
                    hotelList3.add(cell);
                }
            }
        } else {
            hotelList3.addAll(hotelList2);
        }
        
        // 查询房间类型
        ArrayList<HotelPO> hotelList4 = new ArrayList<HotelPO>();
        if (roomType != null) {
            for (HotelPO cell : hotelList3) {
                if (roomService.getHotelRoomType(cell.getName(), startTimestamp, endTimestamp).contains(roomType)) {
                    hotelList4.add(cell);
                }
            }
        } else {
            hotelList4.addAll(hotelList3);
        }
        
        //查询酒店评分
        ArrayList<HotelPO> hotelList5 = new ArrayList<HotelPO>();
        double highRemark = hotelSearchVo.getHighRemark();
        double lowRemark = hotelSearchVo.getLowRemark();
        if(highRemark!=-1){
            for(HotelPO cell:hotelList4){
                if((getHotelRemark(cell.getName())<=highRemark)&&(getHotelRemark(cell.getName())>=lowRemark)){
                    hotelList5.add(cell);
                }
            }
        }else{
            hotelList5.addAll(hotelList4);
        }
        
        ArrayList<HotelColumnVo> hotelVoList = new ArrayList<HotelColumnVo>();
        for (HotelPO cell : hotelList5) {
            hotelVoList.add(new HotelColumnVo(cell.getName(),
                                              roomService.getLowestPrice(cell.getName(), startTimestamp, endTimestamp), cell.getRanking(), evaluateService.getScore(cell.getName())));
        }
        return hotelVoList;
    }

	/**
	 * @param hotelVo
	 * @return 维护酒店信息
	 */
	@Override
	public boolean updateHotel(HotelVo hotelVo) {
		return hotelsDao.updateHotel(hotelVoPoTran.VoToPo(hotelVo));
	}

	/**
	 * @param hotelName
	 * @return 判断酒店是否存在 
	 * 通过维护酒店列表实现
	 */
	@Override
	public boolean judgeHotelExists(String hotelName) {
		return hotelsDao.judgeHotelExists(hotelName);
	}

	/**
	 * @param hotelVo
	 * @return 添加一家新的酒店
	 */
	@Override
	public boolean addHotel(HotelVo hotelVo) {
		return hotelsDao.insertHotel(hotelVoPoTran.VoToPo(hotelVo));
	}

	/**
	 * @param hotelName
	 * @return 用于界面层调用取得酒店分数
	 */
	@Override
	public double getHotelRemark(String hotelName) {
		EvaluateService evaluateService = new Evaluateblimpl();

		return evaluateService.getScore(hotelName);
	}

	/**
	 * @param hotelName
	 * @return 返回一个酒店持久化对象
	 */
	@Override
	public HotelPO getHotelInformation(String hotelName) {
		return hotelsDao.getHotelDetails(hotelName);
	}

	

}

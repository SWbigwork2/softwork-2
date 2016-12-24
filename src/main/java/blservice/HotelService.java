package blservice;

import java.sql.Date;
import java.util.ArrayList;
import po.HotelPO;
import view.member.HotelColumnVo;
import view.member.HotelSearchVo;
import view.member.RoomVo;
import vo.HotelVo;

public interface HotelService {
	/**
	 * 
	 * @param hotelName
	 * @return 根据酒店名称返回酒店Vo
	 */
	public HotelVo getHotelInfo(String hotelName);
	/**
	 * 
	 * @param hotelName
	 * @return 根据酒店名称返回该酒店的房间列表
	 */
	public ArrayList<RoomVo> getRoomOfHotel(String hotelName,Date startTime,Date endTime);
	
	/**
	 * 
	 * @param hotelName
	 * @return 得到酒店评价列表
	 */
	public ArrayList<String> getHotelComment(String hotelName);
	/**
	 * 
	 * @param hotelSearchVo
	 * @return 返回一系列符合条件的酒店
	 */
	public ArrayList<HotelColumnVo> getHotelListInfo(HotelSearchVo hotelSearchVo);
	/**
	 * 
	 * @param hotelVo
	 * @return 更新酒店是否成功
	 */
	public boolean updateHotel(HotelVo hotelVo);
	/**
	 * 
	 * @param hotelName
	 * @return 判断酒店是否存在
	 */
	public boolean judgeHotelExists(String hotelName);
	/**
	 * 
	 * @param hotelVo
	 * @return 添加酒店是否成功
	 */
	public boolean addHotel(HotelVo hotelVo);
	
	
	/**
	 * 
	 * @param hotelName
	 * @return 界面层用于调用来显示分数
	 */
	public double getHotelRemark(String hotelName);
	/**
	 * 
	 * @param hotelName
	 * @return 返回酒店持久化对象
	 */
	public HotelPO getHotelInformation(String hotelName);
	
}

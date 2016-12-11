package blservice;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Map;

import Roomblimpl.RoomType;
import view.member.HotelSearchVo;
import view.member.HotelVo;
import view.member.RoomVo;

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
	 * @return 得到酒店评分
	 */
	public void setHotelRemark(String hotelName,int hotelRemark);
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
	public ArrayList<HotelVo> getHotelListInfo(HotelSearchVo hotelSearchVo);
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
	
}

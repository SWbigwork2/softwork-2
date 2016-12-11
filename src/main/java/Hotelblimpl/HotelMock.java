package Hotelblimpl;

import java.util.ArrayList;

import Roomblimpl.RoomType;
import po.EvaluatePO;
import po.HotelPO;
import po.RoomPO;

public class HotelMock extends HotelServiceImpl {
	// HotelMock需要提供方法供Oreders类、User类、Evaluate类使用

	/*
	 * Oreders类： HotelinfoService.findHotel(String hotelName)
	 * 根据hotelName得到HotelPO对象 RoominfoService.findRoom(String hotelName)
	 * 根据hotelName得到RoomPO对象
	 */

	public HotelPO findHotel(String hotelName) {
		HotelPO hotelPO = new HotelPO(hotelName, "仙林大道103", HotelTradeArea.仙林商圈, "", "", HotelRanking.三星级);
		return hotelPO;
	}

	public ArrayList<RoomPO> findRoom(String hotelName) {
		RoomPO roomPO = new RoomPO("0001", hotelName, RoomType.单人间, "", 100, null);
		ArrayList<RoomPO> list = new ArrayList<RoomPO>();
		list.add(roomPO);
		return list;
	}

	/*
	 * User类： HotelinfoService.addHotel(HotelPO) 添加酒店
	 */

	// 需要User类的ResultMessage
	public ResultMessage addHotel(HotelPO hotelPO) {
		if (hotelPO == null) {
			return ResultMessage.failure;
		} else {
			return ResultMessage.success;
		}
	}

	/*
	 * Evaluate类 HotelinfoService.addHotelEvaluation（EvaluatePO evaluatePO）
	 * 想某一酒店添加评价信息
	 */

	public ResultMessage addHotelEvaluation(EvaluatePO evaluatePO) {
		if (evaluatePO == null) {
			return ResultMessage.failure;
		} else {
			return ResultMessage.success;
		}
	}

}

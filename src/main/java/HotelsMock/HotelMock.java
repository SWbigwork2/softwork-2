package HotelsMock;

import java.util.ArrayList;

import RoomsMock.RoomType;
import po.EvaluatePO;
import po.HotelPO;
import po.RoomPO;

public class HotelMock extends Hotel {
	// HotelMock��Ҫ�ṩ������Oreders�ࡢUser�ࡢEvaluate��ʹ��

	/*
	 * Oreders�ࣺ HotelinfoService.findHotel(String hotelName)
	 * ����hotelName�õ�HotelPO���� RoominfoService.findRoom(String hotelName)
	 * ����hotelName�õ�RoomPO����
	 */

	public HotelPO findHotel(String hotelName) {
		HotelPO hotelPO = new HotelPO(hotelName, "���ִ��103", HotelTradeArea.栖霞区, "", "", HotelRanking.oneStar);
		return hotelPO;
	}

	public ArrayList<RoomPO> findRoom(String hotelName) {
		RoomPO roomPO = new RoomPO("0001", hotelName, RoomType.big, "", 100, new int[3]);
		ArrayList<RoomPO> list = new ArrayList<RoomPO>();
		list.add(roomPO);
		return list;
	}

	/*
	 * User�ࣺ HotelinfoService.addHotel(HotelPO) ��ӾƵ�
	 */

	// ��ҪUser���ResultMessage
	public ResultMessage addHotel(HotelPO hotelPO) {
		if (hotelPO == null) {
			return ResultMessage.failure;
		} else {
			return ResultMessage.success;
		}
	}

	/*
	 * Evaluate�� HotelinfoService.addHotelEvaluation��EvaluatePO evaluatePO��
	 * ��ĳһ�Ƶ����������Ϣ
	 */

	public ResultMessage addHotelEvaluation(EvaluatePO evaluatePO) {
		if (evaluatePO == null) {
			return ResultMessage.failure;
		} else {
			return ResultMessage.success;
		}
	}

}

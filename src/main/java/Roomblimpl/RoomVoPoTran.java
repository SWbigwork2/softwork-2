package Roomblimpl;

import po.RoomPO;
import view.member.RoomVo;


public class RoomVoPoTran {
	
	public RoomPO VoToPo(RoomVo roomVo){
		int roomId = roomVo.getRoomId();
		String hotelBelongTO = roomVo.getHotelBelongTo();
		RoomType roomType = roomVo.getRoomType();
		String roomIntroduction = roomVo.getIntroduction();
		double roomPrice = roomVo.getRoomPrice();
		return new RoomPO(roomId, hotelBelongTO, roomType, roomIntroduction, roomPrice, null);
	}

	public RoomVo PoToVO(RoomPO roomPO) {
		int roomId = roomPO.getId();
		String hotelBelongTO = roomPO.getHotelBelongTo();
		RoomType roomType = roomPO.getRoomType();
		String roomIntroduction = roomPO.getIntroduction();
		double roomPrice = roomPO.getPrice();
		return new RoomVo(roomId, hotelBelongTO, roomType, roomIntroduction, roomPrice);
	}
}

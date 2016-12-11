package Roomblimpl;

import po.RoomPO;
import view.member.RoomVo;

public class RoomVoPoTran {
	
	public RoomPO VoToPo(RoomVo roomVo){
		String roomName = roomVo.getRoomId();
		String hotelBelongTO = roomVo.getHotelBelongTo();
		RoomType roomType = roomVo.getRoomType();
		String roomIntroduction = roomVo.getIntroduction();
		double roomPrice = roomVo.getRoomPrice();
		return new RoomPO(roomName, hotelBelongTO, roomType, roomIntroduction, roomPrice, null);
	}

	public RoomVo PoToVO(RoomPO roomPO) {
		String roomName = roomPO.getRoomName();
		String hotelBelongTO = roomPO.getHotelBelongTo();
		RoomType roomType = roomPO.getRoomType();
		String roomIntroduction = roomPO.getIntroduction();
		double roomPrice = roomPO.getPrice();
		return new RoomVo(roomName, hotelBelongTO, roomType, roomIntroduction, roomPrice);
	}
}

package Roomblimpl;

import java.util.ArrayList;

import po.RoomPO;

public class RoomMock {

	public ArrayList<RoomPO> getRoom(String hotelName) {
		RoomPO roomPO = new RoomPO("0001", hotelName, RoomType.单人间, "", 100, null);
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		roomList.add(roomPO);
		return roomList;
	}
	
	public RoomResultMessage setUnavailablePeroid(int [] list){
		return RoomResultMessage.success;
	}

}

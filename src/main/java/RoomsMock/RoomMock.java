package RoomsMock;

import java.util.ArrayList;

import po.RoomPO;

public class RoomMock {

	private int[] PeriodList = { 1, 2, 3, 4 };

	public ArrayList<RoomPO> getRoom(String hotelName) {
		RoomPO roomPO = new RoomPO("0001", hotelName, RoomType.big, "", 100, null);
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		roomList.add(roomPO);
		return roomList;
	}
	
	public RoomResultMessage setUnavailablePeroid(int [] list){
		return RoomResultMessage.success;
	}

}

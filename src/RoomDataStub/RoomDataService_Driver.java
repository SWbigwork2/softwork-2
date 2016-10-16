package RoomDataStub;

import java.util.ArrayList;
import RoomStub.RoomType;



public class RoomDataService_Driver {
	int [] list ={1,2};
	public void drive(RoomDataService roomDataService){
		RoomPO r = new RoomPO("0001", "qitian", null, "clean and convinent",
				238.0,list );
		ArrayList<RoomPO> roomList = roomDataService.find(r);
		if(roomList.isEmpty()){
			System.out.println("Room doesn't exist.");
		}else{
			System.out.println("Room  exists.");
		}
		roomDataService.insert(r);
		roomDataService.add(r);
		roomDataService.delete(r);
		roomDataService.update(r);
	}

}

package RoomDataStub;

import java.util.ArrayList;
import RoomStub.RoomType;


public class RoomDataServiceSerializableImpl_Stub implements RoomDataService{
	int[]list={1,2};

	@Override
	public void insert(RoomPO h) {
		System.out.println("Insert succeed!");
		
	}

	@Override
	public void add(RoomPO h) {
		System.out.println("Insert succeed!");
	}

	@Override
	public void delete(RoomPO h) {
		System.out.println("Insert succeed!");
		
	}

	@Override
	public void update(RoomPO h) {
		System.out.println("Insert succeed!");
		
	}

	@Override
	public ArrayList<RoomPO> find(RoomPO h) {
		System.out.println("Find succeed!");
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		RoomPO ro = new RoomPO("0001", "qitian", null, "clean and convinent",
				238.0,list );
		roomList.add(ro);
		return roomList;
	}

}

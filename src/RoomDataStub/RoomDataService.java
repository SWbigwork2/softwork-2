package RoomDataStub;

import java.util.ArrayList;

import DataFactoryStub.DataService;



public interface RoomDataService extends DataService{
	public void insert(RoomPO r);
	public void add(RoomPO r);
	public void delete(RoomPO r);
	public void update(RoomPO r);
	public ArrayList<RoomPO> find (RoomPO r);

}

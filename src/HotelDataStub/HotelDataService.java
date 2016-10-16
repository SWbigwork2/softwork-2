package HotelDataStub;

import java.util.ArrayList;

import DataFactoryStub4.DataService;

public interface HotelDataService extends DataService{
	public void insert(HotelPO h);
	public void add(HotelPO h);
	public void delete(HotelPO h);
	public void update(HotelPO h);
	public ArrayList<HotelPO> find (HotelPO h);

}

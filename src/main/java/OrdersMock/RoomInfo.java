package OrdersMock;

import java.sql.Timestamp;
import java.util.ArrayList;

import RoomsMock.RoomType;
import po.RoomPO;

public class RoomInfo extends RoomPO{

	public RoomInfo(String r, String h, RoomType t, String i, double p, ArrayList<Timestamp> list) {
		super(r, h, t, i, p, list);
		// TODO Auto-generated constructor stub
	}
	
}

package OrderStub;

import java.util.ArrayList;
import java.util.Date;

public interface OrdersBlService {
	public OrderVO find(int orderId);
	public ArrayList<OrderVO> getOrderList(int UserId,OrderType orderType);
	public ResultMessage add(int userId,String hotelName, RoomType roomType,int roomNum, int peopleNum, Date beginDate, Date endDate, Date deadline);
	public ResultMessage revoke(int orderId);
	public void confirm();
	public void cancel();
	public void recover(int orderId);
	public void changeError(int orderId);
	
}

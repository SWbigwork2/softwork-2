package data.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import UserServerAssist.ResultMessage;
import UserServerAssist.UserType;
import data.dao.impl.EvaluateDaoImpl;
import data.dao.impl.HotelsDaoImpl;
import data.dao.impl.MembersDaoImpl;
import data.dao.impl.OrdersDaoImpl;
import data.dao.impl.PromotionsDaoImpl;
import data.dao.impl.RoomsDaoImpl;
import data.dao.impl.UserDaoImpl;
import data.dataservice.EvaluateDao;
import data.dataservice.HotelsDao;
import data.dataservice.MembersDao;
import data.dataservice.OrdersDao;
import data.dataservice.PromotionsDao;
import data.dataservice.RoomsDao;
import data.dataservice.UserDao;
import po.CreditrecordPO;
import po.EvaluatePO;
import po.HotelPO;
import po.MemberPO;
import po.OrderPO;
import po.PromotionsIIIPO;
import po.PromotionsIIPO;
import po.PromotionsIPO;
import po.PromotionsIVPO;
import po.PromotionsPO;
import po.PromotionsVIPO;
import po.PromotionsVPO;
import po.RoomPO;
import po.UserPO;

public class DateRemoteObject extends UnicastRemoteObject implements OrdersDao,EvaluateDao,HotelsDao,MembersDao,PromotionsDao,RoomsDao,UserDao{
	private static final long serialVersionUID = 4029039744279087114L;
	private OrdersDao ordersDao;
	private EvaluateDao evaluateDao;
	private HotelsDao hotelsDao;
	private MembersDao membersDao;
	private PromotionsDao promotionsDao;
	private RoomsDao roomsDao;
	private UserDao userDao;
	
	
	
	protected DateRemoteObject() throws RemoteException {
		ordersDao = new OrdersDaoImpl();
		evaluateDao = new EvaluateDaoImpl();
		hotelsDao = new HotelsDaoImpl();
		membersDao = new MembersDaoImpl();
		promotionsDao = new PromotionsDaoImpl();
		roomsDao = new RoomsDaoImpl();
		userDao = new UserDaoImpl();
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserPO findUser(String id, UserType type) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage updateUser(UserPO userPO) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addUser(UserPO userPO) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserPO> getAllUsers(UserType type) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isHotelHasStaff(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<RoomPO> getRoomList(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertRoom(RoomPO roomPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteRoom(String roomID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateRoom(RoomPO roomPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordStartTime(String roomID, Date StartTime, Date EndTime) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean recordCheckOut(String roomID, Date StartTime) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<PromotionsPO> getHotelPromotions(String hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addPromotionsI(PromotionsIPO promotionsIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPromotionsV(PromotionsVPO promotionsVPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePromotions(PromotionsPO promotionsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public MemberPO getMember(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCredit(String id, double changecredit) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCreditRecord(CreditrecordPO po) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<HotelPO> getHotelList(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HotelPO getHotelDetails(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteHotel(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<RoomPO> getRoomOfHotel(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EvaluateServerAssist.ResultMessage addEvaluate(EvaluatePO evaluatePO) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList getEvaluatetion(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderPO getOrder(int orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.getOrder(orderId);
	}

	@Override
	public ArrayList<OrderPO> getHotelOrderList(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.getHotelOrderList(hotelName);
	}

	@Override
	public ArrayList<OrderPO> getOrderList(String userId) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.getOrderList(userId);
	}

	@Override
	public boolean insert(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.insert(po);
	}

	@Override
	public boolean updata(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.updata(po);
	}

	@Override
	public boolean delete(int orderId) throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.delete(orderId);
	}

	@Override
	public ArrayList<OrderPO> getAllOrderList() throws RemoteException {
		// TODO Auto-generated method stub
		return ordersDao.getAllOrderList();
	}

}

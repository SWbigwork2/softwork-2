package data.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import data.dao.EvaluateDao;
import data.dao.HotelsDao;
import data.dao.MembersDao;
import data.dao.OrdersDao;
import data.dao.PromotionsDao;
import data.dao.RoomsDao;
import data.dao.UserDao;
import data.dao.impl.EvaluateDaoImpl;
import data.dao.impl.HotelsDaoImpl;
import data.dao.impl.MembersDaoImpl;
import data.dao.impl.OrdersDaoImpl;
import data.dao.impl.PromotionsDaoImpl;
import data.dao.impl.RoomsDaoImpl;
import data.dao.impl.UserDaoImpl;
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
		return userDao.findUser(id, type);
	}

	@Override
	public ResultMessage updateUser(UserPO userPO) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return userDao.updateUser(userPO);
	}

	@Override
	public ResultMessage addUser(UserPO userPO) throws SQLException, RemoteException {
		// TODO Auto-generated method stub
		return userDao.addUser(userPO);
	}

	@Override
	public ArrayList<UserPO> getAllUsers(UserType type) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.getAllUsers(type);
	}

	@Override
	public boolean isHotelHasStaff(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return userDao.isHotelHasStaff(hotelName);
	}

	@Override
	public ArrayList<PromotionsPO> getHotelPromotions(String hotel) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.getHotelPromotions(hotel);
	}

	@Override
	public boolean addPromotionsI(PromotionsIPO promotionsIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsI(promotionsIPO);
	}

	@Override
	public boolean addPromotionsII(PromotionsIIPO promotionsIIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsII(promotionsIIPO);
	}

	@Override
	public boolean addPromotionsIII(PromotionsIIIPO promotionsIIIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsIII(promotionsIIIPO);
	}

	@Override
	public boolean addPromotionsIV(PromotionsIVPO promotionsIVPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsIV(promotionsIVPO);
	}

	@Override
	public boolean addPromotionsV(PromotionsVPO promotionsVPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsV(promotionsVPO);
	}

	@Override
	public boolean addPromotionsVI(PromotionsVIPO promotionsVIPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.addPromotionsVI(promotionsVIPO);
	}

	@Override
	public boolean deletePromotions(PromotionsPO promotionsPO) throws RemoteException {
		// TODO Auto-generated method stub
		return promotionsDao.deletePromotions(promotionsPO);
	}

	@Override
	public MemberPO getMember(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return membersDao.getMember(id);
	}

	@Override
	public boolean updateCredit(String id, double changecredit) throws RemoteException {
		// TODO Auto-generated method stub
		return membersDao.updateCredit(id, changecredit);
	}

	@Override
	public ArrayList<CreditrecordPO> getMemberCreditRecord(String memberid) throws RemoteException {
		// TODO Auto-generated method stub
		return membersDao.getMemberCreditRecord(memberid);
	}

	@Override
	public void insertCreditRecord(CreditrecordPO po) throws RemoteException {
		// TODO Auto-generated method stub
		membersDao.insertCreditRecord(po);
	}

	@Override
	public ArrayList<HotelPO> getHotelList(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.getHotelList(hotelPO);
	}

	@Override
	public HotelPO getHotelDetails(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.getHotelDetails(hotelName);
	}

	@Override
	public boolean insertHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.insertHotel(hotelPO);
	}

	@Override
	public boolean deleteHotel(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.deleteHotel(hotelName);
	}

	@Override
	public boolean updateHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.updateHotel(hotelPO);
	}

	@Override
	public ArrayList<RoomPO> getRoomOfHotel(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return hotelsDao.getRoomOfHotel(hotelName);
	}

	

	@Override
	public ArrayList getEvaluatetion(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		return evaluateDao.getEvaluatetion(hotelName);
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

	@Override
	public Evaluateblimpl.ResultMessage addEvaluate(EvaluatePO evaluatePO) throws RemoteException {
		// TODO Auto-generated method stub
		return evaluateDao.addEvaluate(evaluatePO);
	}

	@Override
	public boolean recordReservation(int roomID, Date StartTime, Date EndTime, int orderId) throws RemoteException {
		return roomsDao.recordReservation(roomID, StartTime, EndTime, orderId);
	}

	@Override
	public boolean recordCheckOut(int roomID, int orderId) throws RemoteException{
		return roomsDao.recordCheckOut(roomID, orderId);
	}

	@Override
	public ArrayList<Integer> getOrderRoom(int orderId) throws RemoteException {
		return roomsDao.getOrderRoom(orderId);
	}

	@Override
	public boolean recordOrderRoom(int orderId, ArrayList<Integer> roomIdList) throws RemoteException{
		return roomsDao.recordOrderRoom(orderId, roomIdList);
	}

	@Override
	public boolean recordCheckIn(int roomID, int orderId, Date StartTime) throws RemoteException{
		return roomsDao.recordCheckIn(roomID, orderId, StartTime);
	}
	
	@Override
	public ArrayList<RoomPO> getRoomList(String hotelName) throws RemoteException{
		return roomsDao.getRoomList(hotelName);
	}

	@Override
	public boolean insertRoom(RoomPO roomPO) throws RemoteException{
		return roomsDao.insertRoom(roomPO);
	}

	@Override
	public boolean judgeHotelExists(String hotelName) throws RemoteException {
		return roomsDao.judgeHotelEXists(hotelName);
	}

	
}

package DataFactoryStub;



import HotelDataStub.HotelDataService;
import HotelDataStub.HotelDataServiceMysqlImpl_Stub;
import HotelDataStub.HotelDataServiceSerializableImpl_Stub;
import HotelDataStub.HotelDataServiceTxtFileImpl_Stub;
import MemberDataStub.MemberDataService;
import MemberDataStub.MemberDataServiceMysqlImpl_Stub;
import MemberDataStub.MemberDataServiceSerializableImpl_Stub;
import MemberDataStub.MemberDataServiceTxtFileImpl_Stub;
import OrderDataStub.OrdersDataService;
import OrderDataStub.OrdersDataServiceMysqlImpl_Stub;
import OrderDataStub.OrdersDataServiceSerializableImpl_Stub;
import OrderDataStub.OrdersDataServiceTxtFileImpl_Stub;
import PromotionDataStub.PromotionDataService;
import PromotionDataStub.PromotionDataServiceMysqlImpl_Stub;
import PromotionDataStub.PromotionDataServiceSerializableImpl_Stub;
import PromotionDataStub.PromotionDataServiceTxtFileImpl_Stub;
import RoomDataStub.RoomDataService;
import RoomDataStub.RoomDataServiceMysqlImpl_Stub;
import RoomDataStub.RoomDataServiceSerializableImpl_Stub;
import RoomDataStub.RoomDataServiceTxtFileImpl_Stub;
import UserDataStub.UserDataService;
import UserDataStub.UserDataServiceMysqlImpl_Stub;
import UserDataStub.UserDataServiceSerializableImpl_Stub;
import UserDataStub.UserDataServiceTxtFileImpl_Stub;

public class DataFactory_Stub {
	public DataService getUserDate_impl(){
		UserDataService usersDataService = new UserDataServiceMysqlImpl_Stub();
		return usersDataService;
	}
	public DataService getUserDate_txt(){
		UserDataService userDataServiceser = new UserDataServiceTxtFileImpl_Stub();
		return userDataServiceser;
	}
	public DataService getUserDate_serializableImpl(){
		UserDataService usersDataService = new UserDataServiceSerializableImpl_Stub();
		return usersDataService;
	}
	public DataService getOrderDate_impl(){
		OrdersDataService ordersDataService = new OrdersDataServiceMysqlImpl_Stub();
		return ordersDataService;
	}
	public DataService getOrderDate_txt(){
		OrdersDataService ordersDataService = new OrdersDataServiceTxtFileImpl_Stub();
		return ordersDataService;
	}
	public DataService getOrderDate_serializableImpl(){
		OrdersDataService ordersDataService = new OrdersDataServiceSerializableImpl_Stub();
		return ordersDataService;
	}
	public DataService getMemberData_impl1(){
		MemberDataService memberDataService = new MemberDataServiceMysqlImpl_Stub();
		return  memberDataService;
	}
	public DataService getMemberData_txt(){
		MemberDataService memberDataService = new MemberDataServiceTxtFileImpl_Stub();
		return  memberDataService;
	}
	public DataService getMemberData_serializableImpl(){
		MemberDataService memberDataService = new MemberDataServiceSerializableImpl_Stub();
		return  memberDataService;
	}
	public DataService getPromotionData_impl(){
		PromotionDataService promotionDataService = new PromotionDataServiceMysqlImpl_Stub();
		return  promotionDataService;
	}
	public DataService getPromotionData_txt(){
		PromotionDataService promotionDataService = new PromotionDataServiceTxtFileImpl_Stub();
		return  promotionDataService;
	}
	public DataService getPromotionData_serializableImpl(){
		PromotionDataService promotionDataService = new PromotionDataServiceSerializableImpl_Stub();
		return  promotionDataService;
	}
	public DataService getRoomData_impl() {
		RoomDataService roomDataService = new RoomDataServiceMysqlImpl_Stub();
		return roomDataService;
	}

	public DataService getRoomData_txt() {
		RoomDataService roomDataService = new RoomDataServiceTxtFileImpl_Stub();
		return roomDataService;
	}

	public DataService getRoomData_serializableImpl() {
		RoomDataService roomDataService = new RoomDataServiceSerializableImpl_Stub();
		return  roomDataService;
	}
	public DataService getHotelData_impl() {
		HotelDataService hotelDataService = new HotelDataServiceMysqlImpl_Stub();
		return hotelDataService;
	}

	public DataService getHotelData_txt() {
		HotelDataService hotelDataService = new HotelDataServiceTxtFileImpl_Stub();
		return hotelDataService;
	}

	public DataService getHotelData_serializableImpl() {
		HotelDataService hotelDataService = new HotelDataServiceSerializableImpl_Stub();
		return  hotelDataService;
	}
	


}

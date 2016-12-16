package data.rmi;

import java.rmi.Remote;

import data.dao.EvaluateDataService;
import data.dao.HotelsDataService;
import data.dao.MembersDataService;
import data.dao.OrdersDataService;
import data.dao.PromotionsDataService;
import data.dao.RoomsDataService;
import data.dao.UserDataService;
import data.dataservice.EvaluateDao;
import data.dataservice.HotelsDao;
import data.dataservice.MembersDao;
import data.dataservice.OrdersDao;
import data.dataservice.PromotionsDao;
import data.dataservice.RoomsDao;
import data.dataservice.UserDao;

public class RemoteHelper {
	private Remote remote;
	private static RemoteHelper remoteHelper = new RemoteHelper();
	
	public static RemoteHelper getInstance(){
		return remoteHelper;
	}
	private RemoteHelper(){
		
	}
	
	public void setRemote(Remote remote){
		this.remote = remote;
	}
	public EvaluateDao getEvaluateDao(){
		return (EvaluateDao)remote;
	}
	public HotelsDao getHotelsDao(){
		return (HotelsDao)remote;
	}
	public MembersDao getMembersDao(){
		return (MembersDao)remote;
	}
	public OrdersDao getOrdersDao(){
		return (OrdersDao)remote;
	}
	public PromotionsDao getPromotionsDao(){
		return (PromotionsDao)remote;
	}
	public RoomsDao getRoomsDao(){
		return (RoomsDao)remote;
	}
	public UserDao getUsersDao(){
		return (UserDao)remote;
	}

}

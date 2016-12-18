package data.rmi;

import java.rmi.Remote;

import data.dao.EvaluateDao;
import data.dao.HotelsDao;
import data.dao.MembersDao;
import data.dao.OrdersDao;
import data.dao.PromotionsDao;
import data.dao.RoomsDao;
import data.dao.UserDao;

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

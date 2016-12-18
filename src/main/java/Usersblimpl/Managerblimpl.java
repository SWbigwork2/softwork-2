package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.rmi.RemoteHelper;
import po.UserPO;

public class Managerblimpl extends Userblimpl{
	private UserDao userDao;
	private RemoteHelper remoteHelper;
	public Managerblimpl() {
		remoteHelper = RemoteHelper.getInstance();
		userDao = remoteHelper.getUsersDao();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ManagerVO find(String id, UserType type) {
		
	
		ManagerVO manager=null;
		UserPO userPO=null;
		try {
		
			userPO=userDao.findUser(id, type);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		if(userPO!=null){
			manager=(ManagerVO)UserPoVoTran.PoToVo(userPO);
		}
		
		return manager;
	}

	@Override
	public ResultMessage revoke(UserVO user) {
		ResultMessage resultMessage=ResultMessage.fail;
	
		
		try {
			resultMessage=userDao.updateUser(UserPoVoTran.VoToPo(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}
	
}

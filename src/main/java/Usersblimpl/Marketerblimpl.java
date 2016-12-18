package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.rmi.RemoteHelper;
import po.MarketerPO;
import po.UserPO;

public class Marketerblimpl extends Userblimpl{
	private RemoteHelper remoteHelper;
	private UserDao userDao;
	public Marketerblimpl() {
		remoteHelper = RemoteHelper.getInstance();
		userDao = remoteHelper.getUsersDao();
		// TODO Auto-generated constructor stub
	}
	@Override
	public UserVO find(String id, UserType type) {
		
		
		MarketerVO marketer=null;
		UserPO userPO=null;
		try {
		
			userPO=userDao.findUser(id, type);
		
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		if(userPO!=null){
			marketer=(MarketerVO)UserPoVoTran.PoToVo(userPO);
		}
		
		return marketer;
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

	
	public ResultMessage addMarketer(MarketerVO marketerVO){
		ResultMessage resultMessage=ResultMessage.fail;
		MarketerPO marketerPO=(MarketerPO)UserPoVoTran.VoToPo(marketerVO);
		
		
		try {
			resultMessage=userDao.addUser(marketerPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultMessage;
	}
}

package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.MarketerPO;
import po.UserPO;

public class Marketerblimpl extends Userblimpl{

	@Override
	public UserVO find(String id, UserType type) {
		
		UserDao userDao=new UserDaoImpl();
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
		UserDao userDao=new UserDaoImpl();
		
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
		UserDao userDao=new UserDaoImpl();
		
		try {
			resultMessage=userDao.addUser(marketerPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultMessage;
	}
}

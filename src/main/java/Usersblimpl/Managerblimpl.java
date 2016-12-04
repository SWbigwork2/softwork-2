package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.UserPO;

public class Managerblimpl extends Userblimpl{

	@Override
	public ManagerVO find(String id, UserType type) {
		
		UserDao userDao=new UserDaoImpl();
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
		UserDao userDao=new UserDaoImpl();
		
		try {
			resultMessage=userDao.updateUser(UserPoVoTran.VoToPo(user));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}
	
}

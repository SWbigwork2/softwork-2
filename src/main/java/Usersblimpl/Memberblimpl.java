package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.rmi.RemoteHelper;
import po.MemberInformationPO;
import po.UserPO;

public class Memberblimpl extends Userblimpl {
	private UserDao userDao;
	private RemoteHelper remoteHelper;
	public Memberblimpl() {
		remoteHelper = RemoteHelper.getInstance();
		userDao = remoteHelper.getUsersDao();
		// TODO Auto-generated constructor stub
	}
	@Override
	public MemberInformationVO find(String id, UserType type) {
		
		MemberInformationVO member=null;
		UserPO userPO=null;
		try {
		
			userPO=userDao.findUser(id, type);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userPO!=null){
    		member=(MemberInformationVO)UserPoVoTran.PoToVo(userPO);
		}
		
		return member;
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
	
	public ResultMessage register(MemberInformationVO member){
        ResultMessage resultMessage=ResultMessage.fail;
		MemberInformationPO memberInformationPO=(MemberInformationPO)UserPoVoTran.VoToPo(member);
        
	
		try {
			resultMessage=userDao.addUser(memberInformationPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMessage;
	}
	
	

}

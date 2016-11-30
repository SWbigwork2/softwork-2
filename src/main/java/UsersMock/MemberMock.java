package UsersMock;

import java.sql.SQLException;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.MemberInformationPO;
import po.UserPO;

public class MemberMock extends UserMock {

	@Override
	public MemberInformationVO find(String id, UserType type) {
		UserDao userDao=new UserDaoImpl();
		MemberInformationVO member=null;
		UserPO userPO=null;
		try {
		
			userPO=userDao.findUser(id, type);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MemberInformationPO memberInformationPO=(MemberInformationPO)userPO;
		if(memberInformationPO!=null){
			member=new MemberInformationVO(id, memberInformationPO.getPassword(), memberInformationPO.getName()
					,memberInformationPO.getVipType(),memberInformationPO.getCredit(),memberInformationPO.getContactInformation()
					,memberInformationPO.getLevel(),memberInformationPO.getSpecial());
		}
		return member;
	}

	@Override
	public ResultMessage revoke(UserVO user) {
		 ResultMessage resultMessage=ResultMessage.fail;
		 
		 MemberInformationVO member=(MemberInformationVO)user;
		 MemberInformationPO memberInformationPO=new MemberInformationPO(member.getUserId(), member.getName(), member.getPassword()
					,member.getContactInformation(),member.getCredit(),member.getVipType()
					,member.getSpecial(),member.getLevel());
	        
		UserDao userDao=new UserDaoImpl();
		
		try {
			resultMessage=userDao.updateUser(memberInformationPO);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return resultMessage;
	}
	
	public ResultMessage register(MemberInformationVO member){
        ResultMessage resultMessage=ResultMessage.fail;
		MemberInformationPO memberInformationPO=new MemberInformationPO(member.getUserId(), member.getName(), member.getPassword()
				,member.getContactInformation(),member.getCredit(),member.getVipType()
				,member.getSpecial(),member.getLevel());
        
		UserDao userDao=new UserDaoImpl();
		try {
			resultMessage=userDao.addUser(memberInformationPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return resultMessage;
	}
	
	

}

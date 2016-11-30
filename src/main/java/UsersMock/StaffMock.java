package UsersMock;

import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.StaffPO;

public class StaffMock extends UserMock {

	@Override
	public StaffVO find(String id, UserType type){
		UserDao userDao=new UserDaoImpl();
		StaffPO staffPO=null;
		
		try{
		    staffPO=(StaffPO)userDao.findUser(id, type);
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		StaffVO staffVO=null;
		
		if(staffPO!=null){
			
	        staffVO=new StaffVO(id, staffPO.getPassword(), staffPO.getName(), staffPO.getHotelName());
		
		}
		
		return staffVO;
	}

	@Override
	public ResultMessage revoke(UserVO user) {
		ResultMessage resultMessage=null;
		StaffVO staffVO=(StaffVO)user;
		StaffPO staffPO=new StaffPO(staffVO.userId, staffVO.getName(), staffVO.getPassword(), staffVO.getHotelName());
		UserDao userDao= new UserDaoImpl();
        try {
			resultMessage=userDao.updateUser(staffPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultMessage;
	}
    
	public ResultMessage add(HotelInfo hotel,StaffVO staff){
		ResultMessage resultMessage=null;
		//添加酒店
		
		
		//添加工作人员
		StaffPO staffPO=new StaffPO(staff.userId, staff.getName(), staff.getPassword(), staff.getHotelName());
		UserDao userDao= new UserDaoImpl();
        try {
			resultMessage=userDao.updateUser(staffPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultMessage;
	}

	
}

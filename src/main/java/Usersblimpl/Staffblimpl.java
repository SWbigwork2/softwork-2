package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.StaffPO;
import po.UserPO;

public class Staffblimpl extends Userblimpl {

	@Override
	public StaffVO find(String id, UserType type){
		UserDao userDao=new UserDaoImpl();
		UserPO userPO=null;
		
		try{
		    userPO=(StaffPO)userDao.findUser(id, type);
		
		}catch (SQLException e) {
			// TODO: handle exception
		}
		
		StaffVO staffVO=null;
		
		if(userPO!=null){
			
	        staffVO=(StaffVO)UserPoVoTran.PoToVo(userPO);
		
		}
		
		return staffVO;
	}

	@Override
	public ResultMessage revoke(UserVO user) {
		ResultMessage resultMessage=null;
		StaffPO staffPO=(StaffPO)UserPoVoTran.VoToPo(user);
		UserDao userDao= new UserDaoImpl();
        
		try {
			resultMessage=userDao.updateUser(staffPO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return resultMessage;
	}
    
	public ResultMessage add(StaffVO staff){
		ResultMessage resultMessage=ResultMessage.fail;
		UserDao userDao= new UserDaoImpl();
		
			//判断酒店是否存在，不存在就添加酒店
//			HotelService hotelService=new Hotel();
			
			
			//已存在酒店，添加工作人员
	        StaffPO staffPO=(StaffPO)UserPoVoTran.VoToPo(staff);
			
	        try {
				resultMessage=userDao.addUser(staffPO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
        return resultMessage;
	}
	
	public boolean isStaffExist(String hotelName){
		UserDao userDao= new UserDaoImpl();
		return userDao.isHotelHasStaff(hotelName);
	}

	
}

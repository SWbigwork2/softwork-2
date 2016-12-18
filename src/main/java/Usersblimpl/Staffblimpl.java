package Usersblimpl;

import java.sql.SQLException;

import data.dao.UserDao;
import data.rmi.RemoteHelper;
import po.StaffPO;
import po.UserPO;

public class Staffblimpl extends Userblimpl {
	private UserDao userDao;
	private RemoteHelper remoteHelper;
	public Staffblimpl() {
		remoteHelper = RemoteHelper.getInstance();
		userDao = remoteHelper.getUsersDao();
		// TODO Auto-generated constructor stub
	}
	@Override
	public StaffVO find(String id, UserType type){
		
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
		
		return userDao.isHotelHasStaff(hotelName);
	}

	
}

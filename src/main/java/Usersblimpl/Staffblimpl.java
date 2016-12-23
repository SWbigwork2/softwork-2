package Usersblimpl;

import java.sql.SQLException;

import Hotelblimpl.HotelServiceImpl;
import Hotelblimpl.HotelsInfo;
import blservice.HotelService;
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
	
	/**
	 *查找酒店工作人员 
	 */
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

	/**
	 * 修改酒店工作人员信息
	 */
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
    
	/**
	 * 
	 * @param staff
	 * @return 添加酒店工作人员
	 */
	public ResultMessage add(StaffVO staff){
		ResultMessage resultMessage=ResultMessage.fail;
			
	        StaffPO staffPO=(StaffPO)UserPoVoTran.VoToPo(staff);
			
	        HotelService hotelService=new HotelServiceImpl();
	        if(!hotelService.judgeHotelExists(staff.getHotelName())){
	        	return ResultMessage.hotelNotExist;
	        }
	        
	        try {
	        	
				resultMessage=userDao.addUser(staffPO);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
	
        return resultMessage;
	}
	/**
	 * 
	 * @param hotelName
	 * @return 判断酒店是否存在工作人员
	 */
	public boolean isStaffExist(String hotelName){
		
		return userDao.isHotelHasStaff(hotelName);
	}

	
}

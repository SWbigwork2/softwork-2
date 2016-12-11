package Usersblimpl;

import java.util.ArrayList;

import Hotelblimpl.HotelRanking;
import Hotelblimpl.HotelTradeArea;
import blservice.UserService;
import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.UserPO;


public class UserControllerblimpl implements UserService,UserInfo {
    private Userblimpl user;
    
    public UserVO find(String  id,UserType type){
    	
    	if(type.equals(UserType.staff)){
    		
    		user=new Staffblimpl();
    		return user.find(id, UserType.staff);
    
    	}else if(type.equals(UserType.marketer)){
    	
    		user=new Marketerblimpl();
    		return user.find(id, UserType.marketer);
    	
    	}else if(type.equals(UserType.member)){
    	
    		user=new Memberblimpl();
    		return user.find(id, UserType.member);
    	
    	}else if(type.equals(UserType.manager)){
    		user=new Managerblimpl();
    		return user.find(id, type);
    	}
    	
    	return null;
    }
    
    public ResultMessage revoke(String id,UserVO user,UserType type){
    	
    	if(type.equals(UserType.staff)){
    	
    		this.user=new Staffblimpl();
    		return this.user.revoke(user);
    	
    	}else if(type.equals(UserType.marketer)){
    		
    		this.user=new Marketerblimpl();
    		return this.user.revoke(user);
    	
    	}else if(type.equals(UserType.member)){
    		
    		this.user=new Memberblimpl();
    		return this.user.revoke(user);
    	
    	}else if(type.equals(UserType.manager)){
    		
    		this.user=new Managerblimpl();
    		return this.user.revoke(user);
    	}
    	return ResultMessage.fail;
    }
    
    public ResultMessage addStaff(StaffVO staff){	
    	
//    	StaffVO staff=new StaffVO(id,password,name,hotelName);
    	
    	Staffblimpl staffMock=new Staffblimpl();
    	
    	return staffMock.add( staff);
    }
    
    
    
    public ResultMessage addMember(MemberInformationVO member){
		ResultMessage resultMessage =null;
    	
		Memberblimpl memberMock=new Memberblimpl();
		
    	resultMessage=memberMock.register(member);
    	
    	return resultMessage;
    }
    
    public ResultMessage addMarketer(MarketerVO marketer){
    	ResultMessage resultMessage=ResultMessage.fail;
    	
    	Marketerblimpl marketerMock=new Marketerblimpl();
    	
    	resultMessage=marketerMock.addMarketer(marketer);
    	
    	return resultMessage;
    }

	@Override
	public ArrayList<UserVO> getAllUsers(UserType type) {
        ArrayList<UserVO> userList=new ArrayList<UserVO>();
		ArrayList<UserPO> userPOList=null;
        UserDao userDao=new UserDaoImpl();
        userPOList=userDao.getAllUsers(type);
        for(UserPO user:userPOList){
        	UserVO userVO=UserPoVoTran.PoToVo(user);
        	userList.add(userVO);
        }
		return userList;
	}
    
	public boolean isStaffExist(String hotelName){
		Staffblimpl staffblimpl=new Staffblimpl();
		return staffblimpl.isStaffExist(hotelName);
	}
    
}

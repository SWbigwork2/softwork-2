package Usersblimpl;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import blservice.UserService;

public class UserControllerblimpl implements UserService {
    private Userblimpl user;
    
    public UserVO find(String  id,UserType type){
    	
    	if(type.equals(UserType.staff)){
    		
    		user=new StaffMock();
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
    	
    		this.user=new StaffMock();
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
    
    public ResultMessage addStaff(String id,String password,UserType type,String name
    		,String hotelName, String address, HotelTradeArea t, String i, String s, HotelRanking r){
    	
    	
    	HotelInfo hotel=new HotelInfo(hotelName,address,t,i,s,r);
    	
    	StaffVO staff=new StaffVO(id,password,name,hotelName);
    	
    	StaffMock staffMock=new StaffMock();
    	
    	return staffMock.add(hotel, staff);
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
}

package UsersMock;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;

public class UserControllerMock {
    private UserMock user;
    
    public UserVO find(String  id,UserType type){
    	if(type.equals(UserType.staff)){
    		user=new StaffMock();
    		return user.find(id, UserType.staff);
    	}else if(type.equals(UserType.marketer)){
    		user=new MarketerMock();
    		return user.find(id, UserType.marketer);
    	}else if(type.equals(UserType.member)){
    		user=new MemberMock();
    		return user.find(id, UserType.member);
    	}
    	return null;
    }
    
    public ResultMessage revoke(String id,UserVO user,UserType type){
    	if(type.equals(UserType.staff)){
    		this.user=new StaffMock();
    		return this.user.revoke(id, user, UserType.staff);
    	}else if(type.equals(UserType.marketer)){
    		this.user=new MarketerMock();
    		return this.user.revoke(id,user, type);
    	}else if(type.equals(UserType.member)){
    		this.user=new MemberMock();
    		return this.user.revoke(id, user,type);
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
    
    public ResultMessage addMember(String id,String password,UserType type,String name){
    	MemberMock memberMock=new MemberMock();
    	return memberMock.register(new MemberVO(id,password,name));
    }
}

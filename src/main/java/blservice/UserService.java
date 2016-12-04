package blservice;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;

public interface UserService {
	public UserVO find(String  id,UserType type);
	public ResultMessage revoke(String id,UserVO user,UserType type);
	public ResultMessage addStaff(String id,String password,UserType type,String name
	    		,String hotelName, String address, HotelTradeArea t, String i, String s, HotelRanking r);
	public ResultMessage addMember(MemberInformationVO member);
	public ResultMessage addMarketer(MarketerVO marketer);
}

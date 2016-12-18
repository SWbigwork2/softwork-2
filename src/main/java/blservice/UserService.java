package blservice;

import java.util.ArrayList;


import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;


public interface UserService {
	public UserVO find(String  id,UserType type);
	public ResultMessage revoke(String id,UserVO user,UserType type);
	public ResultMessage addStaff(StaffVO staff);
	public ResultMessage addMember(MemberInformationVO member);
	public ResultMessage addMarketer(MarketerVO marketer);
	public ArrayList<UserVO> getAllUsers(UserType type);
	public boolean isStaffExist(String hotelName);
}

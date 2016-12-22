package blservice;

import java.util.ArrayList;


import Usersblimpl.MarketerVO;
import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.StaffVO;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;


public interface UserService {
	
	/**
	 * @param id 用户名
	 * @param type 用户的类型
	 * @return 通过id和type返回相应typeUserVO
	 */
	public UserVO find(String  id,UserType type);
	
	
	/**
	 * @param id=user。getId（）
	 * @param user 需要修改的user信息
	 * @param type =user。getRole（）
	 * @return 修改成员信息
	 */
	public ResultMessage revoke(String id,UserVO user,UserType type);
	
	/**
	 * @param staff 需要注册的staff信息
	 * @return 添加一个新的酒店工作人员
	 */
	public ResultMessage addStaff(StaffVO staff);
	
	/**
	 * @param member
	 * @return 添加一个新的会员
	 */
	public ResultMessage addMember(MemberInformationVO member);
	
	/**
	 * @param marketer
	 * @return 添加一个新的营销人员
	 */
	public ResultMessage addMarketer(MarketerVO marketer);
	
	/**
	 * @param type
	 * @return 得到这个type的所有用户列表
	 */
	public ArrayList<UserVO> getAllUsers(UserType type);
	
	/**
	 * @param hotelName
	 * @return 判断相应的酒店是否存在工作人员
	 */
	public boolean isStaffExist(String hotelName);
}

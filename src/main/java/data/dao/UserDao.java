package data.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import po.UserPO;

public interface UserDao {
	/*
	 * 查询User
	 */
    public UserPO findUser(String id,UserType type) throws SQLException;
    
    /*
     * 修改user的信息
     */
    public ResultMessage updateUser(UserPO userPO) throws SQLException;
    
    /*
     * 添加一个user
     */
    public ResultMessage addUser(UserPO userPO) throws SQLException; 
    
    /**
     * @param type 用户类型
     * @return 所有该类用户的一个集合
     */
    public ArrayList<UserPO> getAllUsers(UserType type);
    
    public boolean isHotelHasStaff(String hotelName);
}

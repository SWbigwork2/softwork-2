package data.dao;

import java.sql.SQLException;

import UsersMock.ResultMessage;
import po.UserPO;
import UsersMock.UserType;

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
}

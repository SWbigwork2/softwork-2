package data.dataHelper;

import java.sql.SQLException;
import java.util.ArrayList;

import UsersMock.ResultMessage;
import po.UserPO;
import UsersMock.UserType;

public interface UserDataHelper {
	/*
	 * 查找用户
	 */
    public ArrayList findUser(String id,UserType type) throws SQLException;
    
    /*
     *修改用户信息 
     */
    public ResultMessage updateUser(UserPO userPO) throws SQLException;
    
    /*
     * 添加用户
     */
    public ResultMessage addUser(UserPO userPO) throws SQLException;
}

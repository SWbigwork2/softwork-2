package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.w3c.dom.ls.LSInput;

import LoginMock.StaffLoginMock;
import OrdersMock.OrderType;
import RoomsMock.RoomType;
import UsersMock.ResultMessage;
import po.UserPO;
import UsersMock.UserType;
import data.dataHelper.UserDataHelper;
import po.ManagerPO;
import po.MemberInformationPO;
import po.OrderPO;
import po.StaffPO;

public class UserDataSqlHelper implements UserDataHelper{

    Connection connection=null;//数据库连接
    PreparedStatement statement=null;//句柄
    ResultSet resultSet = null;//存储结果
    
    private void getConnect() {         //连接到数据库
		String url = "jdbc:mysql://localhost:3306/software2";
		String user = "root";
		String password = "yktobeno.1";
		connection = SqlConnectHelper.getConnection(url, user, password);
		// TODO Auto-generated constructor stub
	}
    
    private void freeConnect(){       //释放连接
		try {
			SqlConnectHelper.close(connection, statement, resultSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    /*
     * 获得查找的userPo的list
     */
    private ArrayList getUserList(String userId,UserType type){
    	
		int id=Integer.parseInt(userId);
		ArrayList list=new ArrayList();//用来保存user的list
		//列表查找
        String users[]={"members","staffs","marketers"};
		UserType userType[]={UserType.member,UserType.staff,UserType.marketer};
		
		try{
		    for(int i=0;i<3;i++){
			    if(type.equals(userType[i])){
			    	this.getConnect();
			    	
				    String selectSql="SELECT * from "+users[i]+" where id="+id;
				    
				    try {
				    	 
						 statement = connection.prepareStatement(selectSql);
						 resultSet= statement.executeQuery();
						 list=this.resultSetToList(resultSet);
						 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    break;
			    }
		    }
		}finally {
			this.freeConnect();
		}
		return list; 
    }
    
    /*
     * 返回给dao一个arraylist
     */
	public ArrayList findUser(String Userid, UserType type) throws SQLException {		
		
		return this.getUserList(Userid, type);
			
	}
    /*
     * 修改信息，传入一个新的userpo,先看有没有，然后把原来的删了，再add一个新的
     */
	public ResultMessage updateUser(UserPO userPO) throws SQLException{
		ResultMessage resultMessage=null;    //结果信息
		
		//如果没有找到就返回没找到
		if(!this.isExist(userPO.getId(), userPO.getRole())){
			return ResultMessage.userNotFound;
		}
		
		//通过列表的方法删除，同时插入
		String usersTable[]={"members","staffs","marketers"};
		UserType userType[]={UserType.member,UserType.staff,UserType.marketer};
		
		//删除原来的user
		for(int i=0;i<3;i++){
			 if(userPO.getRole().equals(userType[i])){
				 String deleteSql="delete from "+usersTable[i]+" where id="+userPO.getId();
				 try {
					 
			        this.getConnect();
					statement = connection.prepareStatement(deleteSql);
					statement.executeUpdate();
				    
				 }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 }finally {
					this.freeConnect();
				 }
				 //添加新的user
				 resultMessage=this.addUser(userPO);
			  }
		}
		return resultMessage;
	}

	/*
	 * 添加用户，传入一个Po，成功返回success，失败返回fail
	 */
	public ResultMessage addUser(UserPO userPO) throws SQLException {
        ResultMessage resultMessage=null;
        
        //如果存在就返回已存在
        if(this.isExist(userPO.getId(), userPO.getRole())){
        	return ResultMessage.userHadExisted;
        }
        
        switch (userPO.getRole()){
        case member:
        	MemberInformationPO member=(MemberInformationPO)userPO;
        	//把date转换
        	Timestamp birthday = new Timestamp(member.getBirthday().getTime());
        	
        	//添加新的用户
        	try {
        		this.getConnect();
				String insertMemberSql="insert into members values("+member.getId()+member.getName()+member.getPassword()
				                             +birthday+member.getCredit()+member.getContactInformation()+")";
				statement = connection.prepareStatement(insertMemberSql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.freeConnect();
			}
        	return ResultMessage.success;        
        
        case staff:
        	StaffPO staff=(StaffPO)userPO;
            
            try {
				this.getConnect();
				String insertStaffSql="insert into staffs values("+staff.getId()+","+"'"+staff.getName()+"'"+","+"'"+staff.getPassword()+"'"+","+
				                             "'"+staff.getHotelName()+"'"+");";
				statement = connection.prepareStatement(insertStaffSql);
				statement.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.freeConnect();
			}
            return ResultMessage.success; 
        }
		return resultMessage;
	}
	
	//把resultSet转成arraylist
	private static ArrayList resultSetToList(ResultSet rs) throws java.sql.SQLException {   //resultset转list，每个订单的数据存在一个map中
        if (rs == null)   {
            return null;  
        }
        ResultSetMetaData md = rs.getMetaData(); //得到结果集(rs)的结构信息，比如字段数、字段名等   
        int columnCount = md.getColumnCount(); //返回此 ResultSet 对象中的列数   
        ArrayList list = new ArrayList();   
        Map rowData = new HashMap();   
        while (rs.next()) {   
         rowData = new HashMap(columnCount);   
         for (int i = 1; i <= columnCount; i++) {   
                 rowData.put(md.getColumnName(i), rs.getObject(i));   
         }   
         list.add(rowData);   
        }   
        return list;   
}  
	
	//判断该用户是否存在
	private boolean isExist(String userId,UserType type){
		if(this.getUserList(userId, type).size()==0){
			return false;
		}else{
			return true;
		}
	}

}

package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import po.UserPO;
import data.dataHelper.UserDataHelper;
import po.ManagerPO;
import po.MarketerPO;
import po.MemberInformationPO;
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
    	
//		String  id=Integer.parseInt(userId);
		ArrayList list=new ArrayList();//用来保存user的list
		//列表查找
        String users[]={"members","staffs","marketers","managers"};
		UserType userType[]={UserType.member,UserType.staff,UserType.marketer,UserType.manager};
		
		try{
		    for(int i=0;i<4;i++){
			    if(type.equals(userType[i])){
			    	this.getConnect();
			    	
				    String selectSql="SELECT * from "+users[i]+" where id="+"'"+userId+"'";
//				    System.out.println(selectSql);
				    
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
		String usersTable[]={"members","staffs","marketers","managers"};
		UserType userType[]={UserType.member,UserType.staff,UserType.marketer,UserType.manager};
		
		//删除原来的user
		for(int i=0;i<usersTable.length;i++){
			 if(userPO.getRole().equals(userType[i])){
				 String deleteSql="delete from "+usersTable[i]+" where id="+"'"+userPO.getId()+"'";
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
            int type=0;
            if(member.getVipType().equals(VipType.CompanyVip)){
            	type++;
            }
        	//添加新的用户
        	try {
        		this.getConnect();
				String insertMemberSql="insert into members values("+"'"+member.getId()+"'"+","+"'"+member.getName()+"'"+
        		                              ","+"'"+member.getPassword()+"'"+","
				                             +"'"+member.getSpecial()+"'"+","+"'"+member.getCredit()+"'"+","+
        		                              "'"+member.getContactInformation()+"'"+","+"'"+type+"'"+","+
				                             "'"+member.getLevel()+"'"+
				                             ")";
				statement = connection.prepareStatement(insertMemberSql);
				statement.executeUpdate();
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
				String insertStaffSql="insert into staffs values("+"'"+staff.getId()+"'"+","+"'"+staff.getName()+"'"+","+"'"+staff.getPassword()+"'"+","+
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
            
        case marketer:
        	MarketerPO marketer=(MarketerPO)userPO;
        	try {
				this.getConnect();
				String insertStaffSql="insert into marketers values("+"'"+marketer.getId()+"'"+","+"'"+marketer.getName()+"'"+","+"'"+marketer.getPassword()+"'"+")";                        
				statement = connection.prepareStatement(insertStaffSql);
				statement.executeUpdate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				this.freeConnect();
			}
            return ResultMessage.success; 
            
        case manager:
        	ManagerPO managerPO=(ManagerPO)userPO;
        	try {
				this.getConnect();
				String insertStaffSql="insert into managers values("+"'"+managerPO.getId()+"'"+","+"'"+managerPO.getName()+"'"+","+"'"+managerPO.getPassword()+"'"+")";                        
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
	
	public ArrayList<UserPO> getAllUsers(UserType type) {
        
		ArrayList<UserPO> userList=null;
       
		String usersTable[]={"members","staffs","marketers"};
		UserType userType[]={UserType.member,UserType.staff,UserType.marketer};
		
		//删除原来的user
		for(int i=0;i<3;i++){
			 if(type.equals(userType[i])){
				 String findSql="select * from "+usersTable[i];
				 try {
					 
			        this.getConnect();
					statement = connection.prepareStatement(findSql);
				    resultSet=statement.executeQuery();
		            

					switch (type){
					case member: userList= this.getMemberList(resultSet);break;
					case staff:userList= this.getStaffList(resultSet);break;
					case marketer:userList= this.getMarketerList(resultSet);break;
					}
				    
				 }catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				 }finally {
					this.freeConnect();
				 }
			 }
		}
        
		
        return userList;		
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

	private ArrayList<UserPO> getStaffList(ResultSet resultSet){
		
		ArrayList<UserPO> staffList=new ArrayList<UserPO>();
		try {
			while(resultSet.next()){
				String staffID=resultSet.getString(1);
				String staffName=resultSet.getString(2);
				String staffPassword=resultSet.getString(3);
				String hotelName=resultSet.getString(4);
				StaffPO staffPO=new StaffPO(staffID, staffName, staffPassword, hotelName);
				staffList.add(staffPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return staffList;
	}
	
    private ArrayList<UserPO> getMarketerList(ResultSet resultSet){
		
		ArrayList<UserPO> managerList=new ArrayList<UserPO>();
		try {
			while(resultSet.next()){
				String marketerID=resultSet.getString(1);
				String marketerName=resultSet.getString(2);
				String marketerPassword=resultSet.getString(3);
				MarketerPO marketerPO=new MarketerPO(marketerID,marketerName,marketerPassword);
				managerList.add(marketerPO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return managerList;
	}
    
    private ArrayList<UserPO> getMemberList(ResultSet resultSet){
    	ArrayList<UserPO> memberList=new ArrayList<UserPO>();
    	
    	try {
			while(resultSet.next()){
				String memberId=resultSet.getString(1);
				String memberName=resultSet.getString(2);
				String memberPassword=resultSet.getString(3);
				String memberSpecial=resultSet.getString(4);
				double credit=resultSet.getDouble(5);
				String memberContact=resultSet.getString(6);
				int type=resultSet.getInt(7);
				int level=resultSet.getInt(8);
				VipType vipType=VipType.CompanyVip;
				if(type==0){
					vipType=VipType.ConmmentVip;
				}
				MemberInformationPO member=new MemberInformationPO(memberId, memberName, memberPassword, memberContact, credit, vipType, memberSpecial, level);			
				memberList.add(member);
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
    	
    	return memberList;
    }
    
	public boolean isHotelHasStaff(String hotelName){
		boolean result=false;
		String findSql="select * from staffs where hotelName= "+"'"+hotelName+"'";
		try {
			 
	        this.getConnect();
			statement = connection.prepareStatement(findSql);
		    resultSet=statement.executeQuery();
            if(resultSet.next()){
            	result=true;
            }
		}catch (SQLException e) {
			// TODO: handle exception
        	e.printStackTrace();
		}finally{
			this.freeConnect();
		}
		
		return result;
		
	}
}

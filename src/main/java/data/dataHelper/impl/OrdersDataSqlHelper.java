package data.dataHelper.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import data.dataHelper.OrdersDataHelper;

public class OrdersDataSqlHelper implements OrdersDataHelper{
	public static void main(String[] args) {
		OrdersDataSqlHelper odsq = new OrdersDataSqlHelper();
		try {
			odsq.getOrdersList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection connection=null;
	
	PreparedStatement statement = null;
	
	ResultSet resultSet = null;
	private static ArrayList resultSetToList(ResultSet rs) throws java.sql.SQLException {   //resultset转list
        if (rs == null)   
            return null;  
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
         System.out.println("list:" + list.toString());   
        }   
        return list;   
}  


	private void getConnect() {         //连接到数据库
		String url = "jdbc:mysql://localhost:3306/software2";
		String user = "root";
		String password = "zhurunzhi654";
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

	public ArrayList getOrdersList() throws SQLException{
		ArrayList tempList = new ArrayList();
		try{
		getConnect();
		String getListSql = "select * from orders";
		statement = connection.prepareStatement(getListSql);
		resultSet = statement.executeQuery();
		tempList=resultSetToList(resultSet); //得到结果的列表，转成array
		// TODO Auto-generated method stub
		
		}
		finally {
			freeConnect();
		}
		return tempList;
	}

	public boolean insertOrder() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updataOrder() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteOrder() {
		// TODO Auto-generated method stub
		return false;
	}

}

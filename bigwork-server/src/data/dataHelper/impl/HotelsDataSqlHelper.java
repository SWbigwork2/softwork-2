package data.dataHelper.impl;

import java.util.ArrayList;

import HotelServerAssist.HotelRanking;
import HotelServerAssist.HotelTradeArea;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.dataHelper.HotelsDataHelper;
import data.dataHelper.RoomsDataHelper;
import po.HotelPO;
import po.RoomPO;

public class HotelsDataSqlHelper implements HotelsDataHelper {

	Connection connection = null;

	PreparedStatement statement = null;

	ResultSet resultSet = null;

	HotelPO hotelPO;
	
	//与数据库连接
	private void getConnect() {
		String url = "jdbc:mysql://localhost:3306/software2?characterEncoding=utf8";
		String user = "root";
		String password = "zhurunzhi654";
		connection = SqlConnectHelper.getConnection(url, user, password);
	}
	
	//与数据库断开连接
	private void freeConnect() {
		try {
			SqlConnectHelper.close(connection, statement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//查询酒店细节的方法，输入酒店名并返回一个酒店PO
	public HotelPO getHotelDetail(String hotelName) {
		getConnect();
		HotelPO h = null;
		try {
			String sqlExpression = "select *from Hotel where HotelName=" + "\"" + hotelName + "\"" + ";";
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String Hotelname = resultSet.getString("HotelName");
				String HotelAddress = resultSet.getString("HotelAddress");
				HotelTradeArea TradeArea = HotelTradeArea.valueOf(resultSet.getString("TradeArea"));
				String HotelIntroduction = resultSet.getString("Introduction");
				String ServiceAndFacility = resultSet.getString("ServiceAndFacility");
				HotelRanking Ranking = HotelRanking.valueOf(resultSet.getString("Ranking"));
				h = new HotelPO(Hotelname, HotelAddress, TradeArea, HotelIntroduction, ServiceAndFacility, Ranking);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}finally{
			freeConnect();
		}
		return h;
	}
	
	/**
	 * 模糊搜索酒店的方法，传入一个酒店PO，其中一定包括确切的酒店商圈以及模糊的酒店地址，也可能包括就点名
	 * 返回一个ArrayList<HotelPO>
	 */
	public ArrayList<HotelPO> getHotelList(HotelPO hotelPO) {
		getConnect();
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		String sqlExpression = "";
		try {
			String hotelAddress = hotelPO.getAddress();
			String TradeArea = hotelPO.getTradeArea().toString();
			String hotelName = hotelPO.getName();
			if (hotelPO.getName() == null) {
				sqlExpression = "select *from Hotel where TradeArea=" + "\"" + TradeArea + "\""
						+ " and HotelAddress like " + "\"" + "%" + hotelAddress + "%" + "\"" + ";";
			} else {
				sqlExpression = "select *from Hotel where TradeArea=" + "\"" + TradeArea + "\""
						+ " and HotelAddress like " + "\"" + "%" + hotelAddress + "%" + "\"" + " and  HotelName like "
						+ "\"" + "%" + hotelName + "%" + "\"" + ";";
			}
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {

				String Hotelname = resultSet.getString("HotelName");
				String HotelAddress = resultSet.getString("HotelAddress");
				HotelTradeArea hotelTradeArea = HotelTradeArea.valueOf(resultSet.getString("TradeArea"));
				String HotelIntroduction = resultSet.getString("Introduction");
				String ServiceAndFacility = resultSet.getString("ServiceAndFacility");
				HotelRanking Ranking = HotelRanking.valueOf(resultSet.getString("Ranking"));

				HotelPO h = new HotelPO(Hotelname, HotelAddress, hotelTradeArea, HotelIntroduction, ServiceAndFacility,
						Ranking);
				hotelList.add(h);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			freeConnect();
		}
		return hotelList;
	}

	public boolean insertHotel(HotelPO hotelPO) {
		getConnect();

		String HotelName = hotelPO.getName();
		String HotelAddress = hotelPO.getAddress();
		String TradeArea = hotelPO.getTradeArea().toString();
		String Introduction = hotelPO.getIntroduction();
		String ServiceAndFacility = hotelPO.getServiceAndFacility();
		String Ranking = hotelPO.getRanking().toString();

		String sqlExpression = "insert into Hotel values" + "(" + "\"" + HotelName + "\"" + "," + "\"" + HotelAddress
				+ "\"" + "," + "\"" + TradeArea + "\"" + "," + "\"" + Introduction + "\"" + "," + "\""
				+ ServiceAndFacility + "\"" + "," + "\"" + Ranking + "\"" + ")" + ";";
		System.out.println(sqlExpression);

		try {
			statement = connection.prepareStatement(sqlExpression);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			freeConnect();
		}
	}

	public boolean deleteHotel(String hotelName) {

		getConnect();
		String sqlExpression = "delete from Hotel where HotelName=" + "\"" + hotelName + "\"" + ";";
		try {
			statement = connection.prepareStatement(sqlExpression);
			statement.executeUpdate();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally{
			freeConnect();
		}
	}

	public boolean updateHotel(HotelPO hotelPO) {
		String hotelName = hotelPO.getName();
		if (deleteHotel(hotelName)) {
			return insertHotel(hotelPO);
		} else {
			freeConnect();
			return false;
		}
	}
	
	/**
	 * 得到酒店房间的方法
	 * 需要调用RoomsDataHelper的getHotelList方法
	 */
	public ArrayList<RoomPO> getRoomOfHotel(String hotelName) {
		RoomsDataHelper roomsDataHelper = new RoomsDataSqlHelper();
		return roomsDataHelper.getRoomList(hotelName);
	}

}

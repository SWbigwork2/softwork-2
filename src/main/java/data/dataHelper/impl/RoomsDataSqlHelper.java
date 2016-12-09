package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Roomblimpl.RoomType;
import data.dataHelper.RoomsDataHelper;
import po.RoomPO;

public class RoomsDataSqlHelper implements RoomsDataHelper {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	// 与数据库连接
	private void getConnect() {
		String url = "jdbc:mysql://localhost:3306/software2?characterEncoding=utf8";
		String user = "root";
		String password = "12345";
		connection = SqlConnectHelper.getConnection(url, user, password);
	}

	// 与数据库断开连接
	private void freeConnect() {
		try {
			SqlConnectHelper.close(connection, statement, resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<RoomPO> getRoomList(String hotelName) {
		getConnect();
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		RoomPO roomPO;
		try {
			String sqlExperssion = "select *from Room where HotelBelongTo=" + "\"" + hotelName + "\"" + ";";
			statement = connection.prepareStatement(sqlExperssion);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String roomID = String.valueOf(resultSet.getInt("RoomID"));
				RoomType roomType = Roomblimpl.RoomType.valueOf(resultSet.getString("RoomType"));
				String roomIntroduction = resultSet.getString("RoomIntroduction");
				double roomPrice = resultSet.getDouble("RoomPrice");

				Timestamp startTime = resultSet.getTimestamp("StartTime");
				Timestamp endTime = resultSet.getTimestamp("EndTime");

				roomPO = new RoomPO(roomID, hotelName, roomType, roomIntroduction, roomPrice, startTime, endTime);
				roomList.add(roomPO);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			freeConnect();
		}
		return roomList;
	}

	public boolean insertRoom(RoomPO roomPO) {
		getConnect();
		try {
			String roomID = roomPO.getRoomName();
			String hotelBelongTo = roomPO.getHotelBelongTo();
			String roomType = roomPO.getRoomType().toString();
			String introduction = roomPO.getIntroduction();
			String price = String.valueOf(roomPO.getPrice());

			String sqlExperssion = "insert into Room values" + "(" + "\"" + roomID + "\"" + "," + "\"" + hotelBelongTo
					+ "\"" + "," + "\"" + roomType + "\"" + "," + "\"" + introduction + "\"" + "," + price
					+ ",null,null);";
			System.out.println(sqlExperssion);
			statement = connection.prepareStatement(sqlExperssion);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public boolean deleteRoom(String roomID) {
		getConnect();
		try {
			String sqlExperssion = "delete from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExperssion);
			statement = connection.prepareStatement(sqlExperssion);
			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public boolean updateRoom(RoomPO roomPO) {
		String roomName = roomPO.getRoomName();
		if (deleteRoom(roomName)) {
			return insertRoom(roomPO);
		} else {
			freeConnect();
			return false;
		}
	}

	public boolean recordStartTime(String roomID, java.util.Date startTime, java.util.Date endTime) {
		getConnect();
		try {
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String startTimeStr = sdf.format(startTime);
			String endTimeStr = sdf.format(endTime);

			Timestamp startTimeSql = null;

			while (resultSet.next()) {
				startTimeSql = resultSet.getTimestamp("StartTime");
			}
			if (startTimeSql != null) {
				System.out.println("房间已经被预定");
				return false;
			} else {
				String sqlExpression1 = "";
				String sqlExpression2 = "";

				sqlExpression1 = "update Room set StartTime= " + "\"" + startTimeStr + "\"" + "where RoomID=" + roomID
						+ ";";
				sqlExpression2 = "update Room set EndTime= " + "\"" + endTimeStr + "\"" + "where RoomID=" + roomID
						+ ";";

				System.out.println(sqlExpression1);
				System.out.println(sqlExpression2);

				statement = connection.prepareStatement(sqlExpression1);
				statement.executeUpdate();

				statement = connection.prepareStatement(sqlExpression2);
				statement.executeUpdate();

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public boolean recordCheckOut(String roomID) {
		getConnect();
		try {
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			Timestamp startTimeSql = null;

			while (resultSet.next()) {
				startTimeSql = resultSet.getTimestamp("StartTime");
			}
			if (startTimeSql == null) {
				System.out.println("该房间无入住信息，无法登记退房信息");
				return false;
			} else {
				String sqlExpression1 = "update Room set StartTime=" + "null" + " where RoomID=" + roomID + ";";
				String sqlExpression2 = "update Room set EndTime=" + "null" + " where RoomID=" + roomID + ";";

				statement = connection.prepareStatement(sqlExpression1);
				statement.executeUpdate();

				statement = connection.prepareStatement(sqlExpression2);
				statement.executeUpdate();

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

}

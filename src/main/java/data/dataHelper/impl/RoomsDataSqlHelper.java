package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import RoomsMock.RoomType;
import data.dataHelper.RoomsDataHelper;
import po.RoomPO;

public class RoomsDataSqlHelper implements RoomsDataHelper {

	Connection connection = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;
	
	//与数据库连接
	private void getConnect() {
		String url = "jdbc:mysql://localhost:3306/software2?characterEncoding=utf8";
		String user = "root";
		String password = "12345";
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

	public ArrayList<RoomPO> getRoomList(String hotelName) {
		getConnect();
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		RoomPO roomPO;
		try {
			String sqlExperssion = "select *from RoomInformation where HotelBelongTo=" + "\"" + hotelName + "\"" + ";";
			statement = connection.prepareStatement(sqlExperssion);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String RoomID = String.valueOf(resultSet.getInt("RoomID"));
				RoomType RoomType = RoomsMock.RoomType.valueOf(resultSet.getString("RoomType"));
				String RoomIntroduction = resultSet.getString("RoomIntroduction");
				double RoomPrice = resultSet.getDouble("RoomPrice");

				ArrayList<Timestamp> dateList = new ArrayList<Timestamp>();
				
				/**
				 * resultSet中记录了最多四个房间不可预订时间戳
				 * 如果时间戳不为null，将该时间戳加入到一个ArrayList<Timestamp>中
				 */
				Timestamp StartTime1 = resultSet.getTimestamp("StartTime1");
				Timestamp EndTime1 = resultSet.getTimestamp("EndTime1");
				Timestamp StartTime2 = resultSet.getTimestamp("StartTime2");
				Timestamp EndTime2 = resultSet.getTimestamp("EndTime2");
				Timestamp StartTime3 = resultSet.getTimestamp("StartTime3");
				Timestamp EndTime3 = resultSet.getTimestamp("EndTime3");
				Timestamp StartTime4 = resultSet.getTimestamp("StartTime4");
				Timestamp EndTime4 = resultSet.getTimestamp("EndTime4");

				if (StartTime1 != null) {
					dateList.add(StartTime1);
					dateList.add(EndTime1);
				}

				if (StartTime2 != null) {
					dateList.add(StartTime2);
					dateList.add(EndTime2);
				}

				if (StartTime3 != null) {
					dateList.add(StartTime3);
					dateList.add(EndTime3);
				}

				if (StartTime4 != null) {
					dateList.add(StartTime4);
					dateList.add(EndTime4);
				}
				roomPO = new RoomPO(RoomID, hotelName, RoomType, RoomIntroduction, RoomPrice, dateList);
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

			String sqlExperssion = "insert into RoomInformation values" + "(" + "\"" + roomID + "\"" + "," + "\""
					+ hotelBelongTo + "\"" + "," + "\"" + roomType + "\"" + "," + "\"" + introduction + "\"" + ","
					+ price + ",null,null,null,null,null,null,null,null);";
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
			String sqlExperssion = "delete from RoomInformation where RoomID=" + roomID + ";";
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

	public boolean recordStartTime(String roomID, java.util.Date StartTime, java.util.Date EndTime) {
		getConnect();
		try {
			String sqlExpression = "select *from RoomInformation where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String startTime = sdf.format(StartTime);
			String endTime = sdf.format(EndTime);

			ArrayList<Timestamp> timeList = new ArrayList<Timestamp>();

			Timestamp StartTime1 = null;
			Timestamp StartTime2 = null;
			Timestamp StartTime3 = null;
			Timestamp StartTime4 = null;

			while (resultSet.next()) {
				StartTime1 = resultSet.getTimestamp("StartTime1");
				StartTime2 = resultSet.getTimestamp("StartTime2");
				StartTime3 = resultSet.getTimestamp("StartTime3");
				StartTime4 = resultSet.getTimestamp("StartTime4");

				timeList.add(StartTime1);
				timeList.add(StartTime2);
				timeList.add(StartTime3);
				timeList.add(StartTime4);
			}

			String sqlExpression1 = "";
			String sqlExpression2 = "";
			if (StartTime1==null) {
				sqlExpression1 = "update RoomInformation set StartTime1= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime1= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime2==null) {
				sqlExpression1 = "update RoomInformation set StartTime2= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime2= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime3==null) {
				sqlExpression1 = "update RoomInformation set StartTime3= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime3= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime4==null) {
				sqlExpression1 = "update RoomInformation set StartTime4= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime4= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			}

			System.out.println(sqlExpression1);
			System.out.println(sqlExpression2);

			statement = connection.prepareStatement(sqlExpression1);
			statement.executeUpdate();

			statement = connection.prepareStatement(sqlExpression2);
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public boolean recordCheckOut(String roomID, java.util.Date StartTime) {
		getConnect();
		try {
			String sqlExpression = "select *from RoomInformation where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			String startTime = sdf.format(StartTime);
			System.out.println(startTime);

			ArrayList<String> timeList = new ArrayList<String>();

			String StartTime1 = "";
			String StartTime2 = "";
			String StartTime3 = "";
			String StartTime4 = "";

			while (resultSet.next()) {
				if (resultSet.getTimestamp("StartTime1") != null) {
					StartTime1 = sdf.format(resultSet.getTimestamp("StartTime1"));
					System.out.println(StartTime1);
					timeList.add(StartTime1);
				}
				if (resultSet.getTimestamp("StartTime2") != null) {
					StartTime2 = sdf.format(resultSet.getTimestamp("StartTime2"));
					timeList.add(StartTime2);
				}
				if (resultSet.getTimestamp("StartTime3") != null) {
					StartTime3 = sdf.format(resultSet.getTimestamp("StartTime3"));
					timeList.add(StartTime3);
				}
				if (resultSet.getTimestamp("StartTime4") != null) {
					StartTime4 = sdf.format(resultSet.getTimestamp("StartTime4"));
					timeList.add(StartTime4);
				}
			}

			String sqlExpression1 = "";
			String sqlExpression2 = "";
			if (startTime.equals(StartTime1)) {
				sqlExpression1 = "update RoomInformation set StartTime1=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime1=" + "null" + " where RoomID=" + roomID + ";";

			} else if (startTime.equals(StartTime2)) {
				sqlExpression1 = "update RoomInformation set StartTime2=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime2=" + "null" + " where RoomID=" + roomID + ";";
			} else if (startTime.equals(StartTime3)) {
				sqlExpression1 = "update RoomInformation set StartTime3=" + "null" + "where RoomID=" + roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime3=" + "null" + " where RoomID=" + roomID + ";";
			} else if (startTime.equals(StartTime4)) {
				sqlExpression1 = "update RoomInformation set StartTime4=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update RoomInformation set EndTime4=" + "null" + " where RoomID=" + roomID + ";";
			}

			System.out.println(sqlExpression1);
			System.out.println(sqlExpression2);

			statement = connection.prepareStatement(sqlExpression1);
			statement.executeUpdate();

			statement = connection.prepareStatement(sqlExpression2);
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}

	}

}

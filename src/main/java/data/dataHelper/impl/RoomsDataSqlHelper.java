package data.dataHelper.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Roomblimpl.RoomType;
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

	public ArrayList<RoomPO> getRoomList(String hotelName) {
		getConnect();
		ArrayList<RoomPO> roomList = new ArrayList<RoomPO>();
		RoomPO roomPO;
		try {
			String sqlExperssion = "select *from Room where HotelBelongTo=" + "\"" + hotelName + "\"" + ";";
			statement = connection.prepareStatement(sqlExperssion);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				String RoomID = String.valueOf(resultSet.getInt("RoomID"));
				RoomType RoomType = Roomblimpl.RoomType.valueOf(resultSet.getString("RoomType"));
				String RoomIntroduction = resultSet.getString("RoomIntroduction");
				double RoomPrice = resultSet.getDouble("RoomPrice");

				Map<Date,Date> dateMap = new HashMap<Date, Date>();
				
				/**
				 * resultSet中记录了最多四个房间不可预订时间戳
				 * 如果时间戳不为null，将该时间戳加入到一个ArrayList<Timestamp>中
				 */
				Date StartTime1 = resultSet.getDate("StartTime1");
				Date EndTime1 = resultSet.getDate("EndTime1");
				Date StartTime2 = resultSet.getDate("StartTime2");
				Date EndTime2 = resultSet.getDate("EndTime2");
				Date StartTime3 = resultSet.getDate("StartTime3");
				Date EndTime3 = resultSet.getDate("EndTime3");
				Date StartTime4 = resultSet.getDate("StartTime4");
				Date EndTime4 = resultSet.getDate("EndTime4");

				if (StartTime1 != null) {
					dateMap.put(StartTime1, EndTime1);
				}

				if (StartTime2 != null) {
					dateMap.put(StartTime2, EndTime2);
				}

				if (StartTime3 != null) {
					dateMap.put(StartTime3, EndTime3);
				}

				if (StartTime4 != null) {
					dateMap.put(StartTime4, EndTime4);
				}
				roomPO = new RoomPO(RoomID, hotelName, RoomType, RoomIntroduction, RoomPrice, dateMap);
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

			String sqlExperssion = "insert into Room values" + "(" + "\"" + roomID + "\"" + "," + "\""
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

	public boolean recordStartTime(String roomID, java.util.Date StartTime, java.util.Date EndTime) {
		getConnect();
		try {
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String startTime = sdf.format(StartTime);
			String endTime = sdf.format(EndTime);



			Date StartTime1 = null;
			Date StartTime2 = null;
			Date StartTime3 = null;
			Date StartTime4 = null;

			while (resultSet.next()) {
				StartTime1 = resultSet.getDate("StartTime1");
				StartTime2 = resultSet.getDate("StartTime2");
				StartTime3 = resultSet.getDate("StartTime3");
				StartTime4 = resultSet.getDate("StartTime4");
			}

			String sqlExpression1 = "";
			String sqlExpression2 = "";
			if (StartTime1==null) {
				sqlExpression1 = "update Room set StartTime1= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update Room set EndTime1= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime2==null) {
				sqlExpression1 = "update Room set StartTime2= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update Room set EndTime2= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime3==null) {
				sqlExpression1 = "update Room set StartTime3= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update Room set EndTime3= " + "\"" + endTime + "\"" + "where RoomID="
						+ roomID + ";";
			} else if (StartTime4==null) {
				sqlExpression1 = "update Room set StartTime4= " + "\"" + startTime + "\"" + "where RoomID="
						+ roomID + ";";
				sqlExpression2 = "update Room set EndTime4= " + "\"" + endTime + "\"" + "where RoomID="
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
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String startTime = sdf.format(StartTime);
			System.out.println(startTime);

			ArrayList<String> timeList = new ArrayList<String>();

			String StartTime1 = "";
			String StartTime2 = "";
			String StartTime3 = "";
			String StartTime4 = "";

			while (resultSet.next()) {
				if (resultSet.getTimestamp("StartTime1") != null) {
					StartTime1 = sdf.format(resultSet.getDate("StartTime1"));
					System.out.println(StartTime1);
					timeList.add(StartTime1);
				}
				if (resultSet.getTimestamp("StartTime2") != null) {
					StartTime2 = sdf.format(resultSet.getDate("StartTime2"));
					timeList.add(StartTime2);
				}
				if (resultSet.getTimestamp("StartTime3") != null) {
					StartTime3 = sdf.format(resultSet.getDate("StartTime3"));
					timeList.add(StartTime3);
				}
				if (resultSet.getTimestamp("StartTime4") != null) {
					StartTime4 = sdf.format(resultSet.getDate("StartTime4"));
					timeList.add(StartTime4);
				}
			}

			String sqlExpression1 = "";
			String sqlExpression2 = "";
			if (startTime.equals(StartTime1)) {
				sqlExpression1 = "update Room set StartTime1=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime1=" + "null" + " where RoomID=" + roomID + ";";

			} else if (startTime.equals(StartTime2)) {
				sqlExpression1 = "update Room set StartTime2=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime2=" + "null" + " where RoomID=" + roomID + ";";
			} else if (startTime.equals(StartTime3)) {
				sqlExpression1 = "update Room set StartTime3=" + "null" + "where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime3=" + "null" + " where RoomID=" + roomID + ";";
			} else if (startTime.equals(StartTime4)) {
				sqlExpression1 = "update Room set StartTime4=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime4=" + "null" + " where RoomID=" + roomID + ";";
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

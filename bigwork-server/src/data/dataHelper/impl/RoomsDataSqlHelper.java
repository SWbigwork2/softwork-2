package data.dataHelper.impl;

import java.sql.Connection;
import java.util.Date;
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
				int RoomID = resultSet.getInt("RoomID");
				RoomType RoomType = Roomblimpl.RoomType.valueOf(resultSet.getString("RoomType"));
				String RoomIntroduction = resultSet.getString("RoomIntroduction");
				double RoomPrice = resultSet.getDouble("RoomPrice");

				Map<Date, Date> dateMap = new HashMap<Date, Date>();

				/**
				 * resultSet中记录了最多四个房间不可预订时间戳
				 * 如果时间戳不为null，将该时间戳加入到一个ArrayList<Date>中
				 */
				Date StartTime1 = new java.util.Date (resultSet.getDate("StartTime1").getTime());
				Date EndTime1 = new java.util.Date (resultSet.getDate("EndTime1").getTime());
				Date StartTime2 = new java.util.Date (resultSet.getDate("StartTime2").getTime());
				Date EndTime2 = new java.util.Date (resultSet.getDate("EndTime2").getTime());
				Date StartTime3 = new java.util.Date (resultSet.getDate("StartTime3").getTime());
				Date EndTime3 = new java.util.Date (resultSet.getDate("EndTime3").getTime());
				Date StartTime4 = new java.util.Date (resultSet.getDate("StartTime4").getTime());
				Date EndTime4 = new java.util.Date (resultSet.getDate("EndTime4").getTime());

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
			int roomID = roomPO.getId();
			String hotelBelongTo = roomPO.getHotelBelongTo();
			String roomType = roomPO.getRoomType().toString();
			String introduction = roomPO.getIntroduction();
			String price = String.valueOf(roomPO.getPrice());

			String sqlExperssion = "insert into Room values" + "(" + "\"" + String.valueOf(roomID) + "\"" + "," + "\"" + hotelBelongTo
					+ "\"" + "," + "\"" + roomType + "\"" + "," + "\"" + introduction + "\"" + "," + price
					+ ",null,null,null,null,null,null,null,null);";
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

	public boolean recordReservation(int roomId, Date StartTime, Date EndTime, int orderId) {
		String roomID = String.valueOf(roomId);
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
			String sqlExpression3 = "";
			if (StartTime1 == null) {
				sqlExpression1 = "update Room set StartTime1= " + "\"" + startTime + "\"" + "where RoomID=" + roomID
						+ ";";
				sqlExpression2 = "update Room set EndTime1= " + "\"" + endTime + "\"" + "where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId1= " +  String.valueOf(orderId)  + " where RoomID="
						+ roomID + ";";
			} else if (StartTime2 == null) {
				sqlExpression1 = "update Room set StartTime2= " + "\"" + startTime + "\"" + "where RoomID=" + roomID
						+ ";";
				sqlExpression2 = "update Room set EndTime2= " + "\"" + endTime + "\"" + "where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId2= "  + String.valueOf(orderId) + " where RoomID="
						+ roomID + ";";
			} else if (StartTime3 == null) {
				sqlExpression1 = "update Room set StartTime3= " + "\"" + startTime + "\"" + "where RoomID=" + roomID
						+ ";";
				sqlExpression2 = "update Room set EndTime3= " + "\"" + endTime + "\"" + "where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId3= "  + String.valueOf(orderId)  + " where RoomID="
						+ roomID + ";";
			} else if (StartTime4 == null) {
				sqlExpression1 = "update Room set StartTime4= " + "\"" + startTime + "\"" + "where RoomID=" + roomID
						+ ";";
				sqlExpression2 = "update Room set EndTime4= " + "\"" + endTime + "\"" + "where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId4= "  + String.valueOf(orderId)  + " where RoomID="
						+ roomID + ";";
			}

			System.out.println(sqlExpression1);
			System.out.println(sqlExpression2);
			System.out.println(sqlExpression3);

			statement = connection.prepareStatement(sqlExpression1);
			statement.executeUpdate();

			statement = connection.prepareStatement(sqlExpression2);
			statement.executeUpdate();

			statement = connection.prepareStatement(sqlExpression3);
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public boolean recordCheckOut(int roomId, int orderId) {
		String roomID = String.valueOf(roomId);
		getConnect();
		try {
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			int orderId1 = 0;
			int orderId2 = 0;
			int orderId3 = 0;
			int orderId4 = 0;

			while (resultSet.next()) {
				orderId1 = resultSet.getInt("OrderId1");
				orderId2 = resultSet.getInt("OrderId2");
				orderId3 = resultSet.getInt("OrderId3");
				orderId4 = resultSet.getInt("OrderId4");
			}

			String sqlExpression1 = "";
			String sqlExpression2 = "";
			String sqlExpression3 = "";
			if (orderId1 == orderId) {
				sqlExpression1 = "update Room set StartTime1=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime1=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId1=" + "null" + " where RoomID=" + roomID + ";";

			} else if (orderId2 == orderId) {
				sqlExpression1 = "update Room set StartTime2=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime2=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId2=" + "null" + " where RoomID=" + roomID + ";";
			} else if (orderId3 == orderId) {
				sqlExpression1 = "update Room set StartTime3=" + "null" + "where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime3=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId3=" + "null" + " where RoomID=" + roomID + ";";
			} else if (orderId4 == orderId) {
				sqlExpression1 = "update Room set StartTime4=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression2 = "update Room set EndTime4=" + "null" + " where RoomID=" + roomID + ";";
				sqlExpression3 = "update Room set OrderId4=" + "null" + " where RoomID=" + roomID + ";";
			}

			System.out.println(sqlExpression1);
			System.out.println(sqlExpression2);
			System.out.println(sqlExpression3);

			statement = connection.prepareStatement(sqlExpression1);
			statement.executeUpdate();

			statement = connection.prepareStatement(sqlExpression2);
			statement.executeUpdate();
			
			statement = connection.prepareStatement(sqlExpression3);
			statement.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}

	}

	public boolean recordOrderRoom(int orderId, ArrayList<Integer> roomIdList) {
		getConnect();
		try {
			int length = roomIdList.size();
			String sqlExpression = "";
			switch (length) {
			case 1:
				sqlExpression = "insert into orderIdToRoom values" + "(" + "\"" + orderId + "\"" + "," + "\""
						+ String.valueOf(roomIdList.get(0)) + "\"" + ",null,null);";
				break;
			case 2:
				sqlExpression = "insert into orderIdToRoom values" + "(" + "\"" + orderId + "\"" + "," + "\""
						+ String.valueOf(roomIdList.get(0)) + "\"" + "," + "\"" + String.valueOf(roomIdList.get(1)) + "\"" + ",null);";
				break;
			case 3:
				sqlExpression = "insert into orderIdToRoom values" + "(" + "\"" + orderId + "\"" + "," + "\""
						+ String.valueOf(roomIdList.get(0)) + "\"" + "," + "\"" + String.valueOf(roomIdList.get(1)) + "\"" + "," + "\""
						+ String.valueOf(roomIdList.get(2)) + "\"" + ");";
				break;
			}
			System.out.println(sqlExpression);

			statement = connection.prepareStatement(sqlExpression);
			statement.executeUpdate();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			freeConnect();
		}
	}

	public ArrayList<Integer> getOrderRoom(int orderId) {
		getConnect();
		try {
			String sqlExpression = "select *from orderIdToRoom where orderId =" + String.valueOf(orderId) + ";";
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			int roomId1 = 0;
			int roomId2 = 0;
			int roomId3 = 0;
			while (resultSet.next()) {
				roomId1 = resultSet.getInt("RoomID1");
				roomId2 = resultSet.getInt("RoomID2");
				roomId3 = resultSet.getInt("RoomID3");
			}
			ArrayList<Integer> roomList = new ArrayList<Integer>();
			if (roomId1 != 0) {
				roomList.add(roomId1);
			}
			if (roomId2 != 0) {
				roomList.add(roomId2);
			}
			if (roomId3 != 0) {
				roomList.add(roomId3);
			}
			return roomList;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			freeConnect();
		}
	}

	public boolean recordCheckIn(int roomId, int orderId, Date StartTime) {
		String roomID = String.valueOf(roomId);
		getConnect();
		try {
			String sqlExpression = "select *from Room where RoomID=" + roomID + ";";
			System.out.println(sqlExpression);
			statement = connection.prepareStatement(sqlExpression);
			resultSet = statement.executeQuery();

			DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String startTime = sdf.format(StartTime);

			int orderId1 = 0;
			int orderId2 = 0;
			int orderId3 = 0;
			int orderId4 = 0;

			while (resultSet.next()) {
				orderId1 = resultSet.getInt("OrderId1");
				orderId2 = resultSet.getInt("OrderId2");
				orderId3 = resultSet.getInt("OrderId3");
				orderId4 = resultSet.getInt("OrderId4");
			}

			sqlExpression = "";
			if (orderId1 == orderId) {
				sqlExpression = "update Room set StartTime1=" + "\"" + startTime + "\"" + " where RoomID=" + roomID
						+ ";";

			} else if (orderId2 == orderId) {
				sqlExpression = "update Room set StartTime2=" + "\"" + startTime + "\"" + " where RoomID=" + roomID
						+ ";";
			} else if (orderId3 == orderId) {
				sqlExpression = "update Room set StartTime3=" + "\"" + startTime + "\"" + "where RoomID=" + roomID
						+ ";";
			} else if (orderId4 == orderId) {
				sqlExpression = "update Room set StartTime4=" + "\"" + startTime + "\"" + " where RoomID=" + roomID
						+ ";";
			}

			System.out.println(sqlExpression);

			statement = connection.prepareStatement(sqlExpression);
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

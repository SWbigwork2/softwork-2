package OrdersTester;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import HotelsMock.HotelPO;
import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import HotelsMock.HotelsInfo;
import MembersMock.MemberPO;
import MembersMock.MembersInfo;


import OrdersMock.OrderItem;
import OrdersMock.OrderType;
import OrdersMock.OrderVO;
import OrdersMock.OrdersListMock;
import OrdersMock.OrdersMock;

import PromotionsMock.Promotions;
import RoomsMock.RoomPO;
import RoomsMock.RoomType;
import RoomsMock.RoomsInfo;

public class OrderTest {
	Date date = new Date(2016, 11,1);
	
	RoomsInfo rI = new RoomPO("0001", "ª ≥Ø", RoomType.big, "", 100, new int[3]);
	MembersInfo mI = new MemberPO("0001", "admin","admin","10086", 300);
	HotelsInfo hI = new HotelPO("ª ≥Ø", "œ…¡÷¥Ûµ¿103",HotelTradeArea.∆‹œº«¯, "", "", HotelRanking.oneStar);
	Promotions po = new Promotions();
	@Test
	public void Addtest() {
		
		OrdersMock ordersMock= new OrdersMock();
		ordersMock.setUp(po, hI, rI, mI);
		ordersMock.add(1, 2,date, date, date);
		OrderVO vo=ordersMock.view();
		assertEquals(vo.userNameString, "admin");
		assertEquals(vo.hotelNameString, "ª ≥Ø");
		
	}
	@Test
	public void confirmTest(){
		OrdersMock ordersMock= new OrdersMock();
		ordersMock.setUp(po, hI, rI, mI);
		ordersMock.add(1,2, date, date, date);
		OrdersListMock listMock = ordersMock.getList();
		ArrayList<OrderItem> orderList = listMock.getList(OrderType.normal);
		int preSize = orderList.size();
		ordersMock.confirm();
		listMock = ordersMock.getList();
		orderList = listMock.getList(OrderType.normal);
		int pastSize =  orderList.size();
		assertEquals(pastSize-preSize, 1);
	}
	@Test
	public void calPrice(){
		OrdersMock ordersMock= new OrdersMock();
		ordersMock.setUp(po, hI, rI, mI);
		ordersMock.add(1,2, date, date, date);
		OrderVO vo=ordersMock.view();
		assertEquals(vo.price, 200.0,0.000001);
	}

}

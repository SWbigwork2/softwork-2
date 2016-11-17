package HotelTester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import EvaluateMock.EvaluatePO;
import HotelsMock.HotelPO;
import HotelsMock.HotelMock;
import HotelsMock.ResultMessage;


public class HotelTest {
	
	@Test
	public void findHoteltTest(){
		HotelMock hotelMock = new HotelMock();
		HotelsMock.HotelPO po = hotelMock.findHotel("���극��");
		assertEquals(po.getName(), "���극��");	
	}
	
	@Test
	public void findHoteltTest2(){
		HotelMock hotelMock2 = new HotelMock();
		HotelsMock.HotelPO po2 = hotelMock2.findHotel("��������");
		assertEquals(po2.getName(), "��������");
	}
	@Test
	public void addHotelTest1(){
		HotelMock hotelMock3 = new HotelMock();
		ResultMessage  r = hotelMock3.addHotel(null);
		assertEquals(r,ResultMessage.failure);
	}
	@Test
	public void addHotelTest2(){
		HotelMock hotelMock4 = new HotelMock();
		HotelPO p = new HotelPO("�Ͼ�����", null, null, null, null, null);
		ResultMessage  r = hotelMock4.addHotel(p);
		assertEquals(r,ResultMessage.success);
	}
	@Test
	public void addEvaluationTest1(){
		HotelMock hotelMock5 = new HotelMock();
		ResultMessage  r = hotelMock5.addHotelEvaluation(null);
		assertEquals(r,ResultMessage.failure);
	}
	@Test
	public void addEvaluationTest2(){
		HotelMock hotelMock6 = new HotelMock();
		EvaluatePO evaluatePO = new EvaluatePO("�Ͼ�����", null, 0, 0, null);
		ResultMessage  r = hotelMock6.addHotelEvaluation(evaluatePO);
		assertEquals(r,ResultMessage.success);
	}
	

	
	
	
	
	

}

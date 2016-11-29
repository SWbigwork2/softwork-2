package HotelTester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import HotelsMock.HotelMock;
import HotelsMock.ResultMessage;
import po.EvaluatePO;
import po.HotelPO;


public class HotelTest {
	
	@Test
	public void findHoteltTest(){
		HotelMock hotelMock = new HotelMock();
		po.HotelPO po = hotelMock.findHotel("金陵饭店");
		assertEquals(po.getName(), "金陵饭店");	
	}
	
	@Test
	public void findHoteltTest2(){
		HotelMock hotelMock2 = new HotelMock();
		po.HotelPO po2 = hotelMock2.findHotel("苏宁环球");
		assertEquals(po2.getName(), "苏宁环球");
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
		HotelPO p = new HotelPO("南京饭店", null, null, null, null, null);
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
		EvaluatePO evaluatePO = new EvaluatePO("南京饭店", null, 0, 0, null);
		ResultMessage  r = hotelMock6.addHotelEvaluation(evaluatePO);
		assertEquals(r,ResultMessage.success);
	}
	

	
	
	
	
	

}

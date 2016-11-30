package data.HotelTester;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import HotelsMock.HotelRanking;
import HotelsMock.HotelTradeArea;
import data.dao.HotelsDao;
import data.dao.impl.HotelsDaoImpl;
import po.HotelPO;

public class HotelTester {
	@Test
	public void insertTest(){
		HotelsDao hotelsDao = HotelsDaoImpl.getInstance();
		HotelPO hotelPO1 = new HotelPO("金陵饭店","中山东路1号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		HotelPO hotelPO2 = new HotelPO("苏宁环球饭店","中山东路2号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		hotelsDao.insertHotel(hotelPO1);
		hotelsDao.insertHotel(hotelPO2);
		HotelPO hotelsTestPO = hotelsDao.getHotelDetails("金陵饭店");
		assertEquals(hotelsTestPO.getAddress(), hotelPO1.getAddress());
		assertEquals(hotelsTestPO.getIntroduction(), hotelPO1.getIntroduction());
		assertEquals(hotelsTestPO.getTradeArea(), hotelPO1.getTradeArea());
		assertEquals(hotelsTestPO.getServiceAndFacility(), hotelPO1.getServiceAndFacility());
		assertEquals(hotelsTestPO.getRanking(), hotelPO1.getRanking());
		assertEquals(hotelsTestPO.getName(), hotelPO1.getName());
		
		hotelsDao.deleteHotel("金陵饭店");
		hotelsDao.deleteHotel("苏宁环球饭店");
	}
	
	@Test
	public void deleteTest(){
		HotelsDao hotelsDao = HotelsDaoImpl.getInstance();
		
		HotelPO hotelPO1 = new HotelPO("金陵饭店","中山东路1号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		HotelPO hotelPO2 = new HotelPO("苏宁环球饭店","中山东路2号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		hotelsDao.insertHotel(hotelPO1);
		hotelsDao.insertHotel(hotelPO2);
		
		hotelsDao.deleteHotel("金陵饭店");
		HotelPO hotelPO = new HotelPO("金陵饭店","中山东路5号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		hotelsDao.insertHotel(hotelPO);
		HotelPO hotelsTestPO = hotelsDao.getHotelDetails("金陵饭店");
		assertEquals(hotelsTestPO.getAddress(), hotelPO.getAddress());
		
		hotelsDao.deleteHotel("金陵饭店");
		hotelsDao.deleteHotel("苏宁环球饭店");
	}
	
	@Test
	public  void getListTest(){
		HotelsDao hotelsDao = HotelsDaoImpl.getInstance();
		
		HotelPO hotelPO1 = new HotelPO("金陵饭店","中山东路1号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		HotelPO hotelPO2 = new HotelPO("苏宁环球饭店","中山东路2号",HotelTradeArea.鼓楼区,"舒适","无线网络",HotelRanking.FiveStar);
		hotelsDao.insertHotel(hotelPO1);
		hotelsDao.insertHotel(hotelPO2);
		
		HotelPO hotelPO = new HotelPO("南京饭店","仙林大道163号",HotelTradeArea.栖霞区,"舒适","无线网络",HotelRanking.FiveStar);
		hotelsDao.insertHotel(hotelPO);
		HotelPO testPO = new HotelPO(null,"中山东路",HotelTradeArea.鼓楼区,null,null,null);
		ArrayList <HotelPO> list = hotelsDao.getHotelList(testPO);
		for(HotelPO cell:list){
			assertEquals(cell.getTradeArea(),HotelTradeArea.鼓楼区);
		}
		
		hotelsDao.deleteHotel("金陵饭店");
		hotelsDao.deleteHotel("苏宁环球饭店");
		hotelsDao.deleteHotel("南京饭店");
	}

}

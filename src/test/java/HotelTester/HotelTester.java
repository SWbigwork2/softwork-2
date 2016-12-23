package HotelTester;

import static org.junit.Assert.*;

import org.junit.Test;

import Hotelblimpl.HotelServiceImpl;
import blservice.HotelService;
import vo.HotelVo;

public class HotelTester {
	
	@Test
	public void getHotelListTest(){
		HotelService hotelService = new HotelServiceImpl();
		HotelVo hotelVo = new HotelVo("南京大饭店", "中央大路", null, null, null, null);
		hotelService.addHotel(hotelVo);
		HotelVo hotelVo1= hotelService.getHotelInfo("南京大饭店");
		assertEquals(hotelVo1.getAddress(),"中央大路");
	}
	
	@Test
	public void updateHotelTest(){
		HotelService hotelService = new HotelServiceImpl();
		HotelVo hotelVo = new HotelVo("金陵饭店", "中央大路", null, null, null, null);
		hotelService.addHotel(hotelVo);
		hotelService.updateHotel(hotelVo);
		HotelVo hotelVo1 = hotelService.getHotelInfo("金陵饭店");
		assertEquals(hotelVo1.getAddress(),"中央大路");
	}

}

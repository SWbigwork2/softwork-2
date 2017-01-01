package OrderTester;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import Roomblimpl.RoomType;
import ordersblimpl.OrderPoVoTran;
import ordersblimpl.OrderType;
import po.OrderPO;
import vo.OrderVo;

public class OrderPoTransTest {
	OrderPO testPo;
	OrderVo testVo;
	OrderPoVoTran trans;
	@Before
	public void init(){
		testPo = new OrderPO(123456, "1000", "admin", "金陵饭店",RoomType.单人间, 1, 200.0, OrderType.normal, new Date(), new Date(), new Date(), new Date(), 2, new Date(), false);
		trans = new OrderPoVoTran();
	}

	/**
	 * 测试po转换为vo
	 */
	@Test
	public void po2voTest() {
		testVo = trans.po2vo(testPo);
		assertEquals(testVo.getOrderId(), testPo.getOrderId());
		assertEquals(testVo.getBeginDate(), testPo.getBeginDate());
		assertEquals(testVo.isHasChild(), testPo.isHasChild());
		assertEquals(testVo.getUserId(), testPo.getUserId());
		assertEquals(testVo.getRoomType(), testPo.getRoomType().toString());
		
	}
	@Test
	public void vo2poTest(){
		testVo = trans.po2vo(testPo);
		OrderPO tempPo = trans.vo2po(testVo);
		assertEquals(tempPo.getOrderId(), testPo.getOrderId());
		assertEquals(tempPo.getBeginDate(), testPo.getBeginDate());
		assertEquals(tempPo.isHasChild(), testPo.isHasChild());
		assertEquals(tempPo.getUserId(), testPo.getUserId());
		assertEquals(tempPo.getRoomType(), testPo.getRoomType());
	}

}

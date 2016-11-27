package data.usersTster;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import UsersMock.ResultMessage;
import UsersMock.UserType;
import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.StaffPO;

public class UserTester {
    StaffPO staffPO=new StaffPO("1001", "张天天", "zhangtiantian", "七天快捷酒店");
    StaffPO staffPO2=new StaffPO("1004","劳尔·卡斯特罗","kasiteluo","古巴大饭店");
    StaffPO staffPO3=new StaffPO("1001", "张天天二期", "zhangtiantian", "七天快捷酒店");
    StaffPO staffPO4=new StaffPO("1005", "张天", "zhangtiantian", "七天快捷酒店");
    
    @Test
	public void findtester() {
    	UserDao dao = UserDaoImpl.getInstance();
		StaffPO po=null;
		try {
			po = (StaffPO)dao.findUser("1001", UserType.staff);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("1001", po.getId());
		assertEquals("张天天", po.getName());
		assertEquals("zhangtiantian", po.getPassword());
		assertEquals(staffPO.getHotelName(), po.getHotelName());
	}
	
	@Test
	public void addTester(){
		ResultMessage resultMessage=null;
		ResultMessage resultMessage2=null;
	    UserDao dao=UserDaoImpl.getInstance();
	    try{
	    	resultMessage=dao.addUser(staffPO);
	    	resultMessage2=dao.addUser(staffPO2);
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    assertEquals(ResultMessage.userHadExisted, resultMessage);
	    assertEquals(ResultMessage.success, resultMessage2);
	}
	
    @Test
    public void updateTest() throws SQLException{
    	ResultMessage resultMessage=null;
		ResultMessage resultMessage2=null;
	    UserDao dao=UserDaoImpl.getInstance();
	    resultMessage=dao.updateUser(staffPO);
		resultMessage2=dao.updateUser(staffPO4);
	    assertEquals(ResultMessage.userNotFound, resultMessage2);
	    assertEquals(ResultMessage.success, resultMessage);
    }
}

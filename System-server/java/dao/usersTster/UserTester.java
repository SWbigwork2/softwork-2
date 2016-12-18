package dao.usersTster;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import Usersblimpl.ManagerVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import Usersblimpl.VipType;
import data.dao.UserDataService;
import data.dao.impl.UserDaoImpl;
import po.ManagerPO;
import po.MemberInformationPO;
import po.StaffPO;

public class UserTester {
    StaffPO staffPO=new StaffPO("1001", "张天天", "zhangtiantian", "七天快捷酒店");
    StaffPO staffPO2=new StaffPO("1004","劳尔·卡斯特罗","kasiteluo","古巴大饭店");
    StaffPO staffPO3=new StaffPO("1001", "张天天二期", "zhangtiantian", "七天快捷酒店");
    StaffPO staffPO4=new StaffPO("1005", "张天", "zhangtiantian", "七天快捷酒店");
    
    @Test
	public void findtester() {
    	UserDataService dao = UserDaoImpl.getInstance();
		ManagerPO po=null;
		try {
			po = (ManagerPO)dao.findUser("1000", UserType.manager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("1000", po.getId());
		assertEquals("夏天", po.getName());
		assertEquals("summerday", po.getPassword());
	}
	
//	@Test
	public void addTester(){
		ResultMessage resultMessage=null;
		ResultMessage resultMessage2=null;
	    UserDataService dao=UserDaoImpl.getInstance();
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
	
//    @Test
    public void updateTest() throws SQLException{
    	ResultMessage resultMessage=null;
		ResultMessage resultMessage2=null;
	    UserDataService dao=UserDaoImpl.getInstance();
	    resultMessage=dao.updateUser(staffPO);
		resultMessage2=dao.updateUser(staffPO4);
	    assertEquals(ResultMessage.userNotFound, resultMessage2);
	    assertEquals(ResultMessage.success, resultMessage);
    }
    
//    @Test
    public void addMemberTest() throws SQLException{
    	MemberInformationPO memberInformationPO=new MemberInformationPO("1010", "ykky", "yktobeno.1", "12333", 100, VipType.ConmmentVip, "1997-03-09", 1);
    	ResultMessage resultMessage=ResultMessage.success;
    	UserDataService dao =UserDaoImpl.getInstance();
    	assertEquals(resultMessage,dao.addUser(memberInformationPO));
    }
    
    @Test 
    public void isHotelTset(){
    	UserDataService dao =new UserDaoImpl().getInstance();
    	assertEquals(true, dao.isHotelHasStaff("古巴大饭店"));
    	
    }
}

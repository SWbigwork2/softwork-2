package data.usersTster;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;

import com.sun.media.jfxmedia.events.NewFrameEvent;

import Usersblimpl.ManagerVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserType;
import data.dao.UserDao;
import data.dao.impl.UserDaoImpl;
import po.ManagerPO;
import po.StaffPO;

public class UserTester {
    ManagerPO ManagerPO=new ManagerPO("1234", "12", "1111");   
    ManagerPO po=new ManagerPO("1234","1234", "1111");
    
   
	
//	@Test
	public void addTester() throws RemoteException{
		ResultMessage resultMessage=null;
	    UserDao dao=UserDaoImpl.getInstance();
	    try{
	    	resultMessage=dao.addUser(ManagerPO);
	    }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    assertEquals(ResultMessage.success, resultMessage);
	}
	
	 @Test
		public void findtester() throws RemoteException {
	    	UserDao dao = UserDaoImpl.getInstance();
			ManagerPO po=null;
			try {
				po = (ManagerPO)dao.findUser("1234", UserType.manager);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals("1234", po.getId());
			assertEquals("1234", po.getName());
			assertEquals("1111", po.getPassword());
		}
	
//    @Test
    public void updateTest() throws SQLException, RemoteException{
    	ResultMessage resultMessage=null;
	    UserDao dao=UserDaoImpl.getInstance();
	    
	    resultMessage=dao.updateUser(po);
	    assertEquals(ResultMessage.success, resultMessage);
    }
}

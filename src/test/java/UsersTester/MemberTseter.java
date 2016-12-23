package UsersTester;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.UserVO;
import Usersblimpl.VipType;
import data.rmi.RemoteHelper;
import po.UserPO;

public class MemberTseter {
	private RemoteHelper remoteHelper;
    UserControllerblimpl usm=new UserControllerblimpl();
    MemberInformationVO memberInformationVO= new MemberInformationVO("1123", "song", "song"
    		, 100, null, "1", "1997-5-2", VipType.ConmmentVip.name());

//    @Test
    public void addmemberTest(){
        ResultMessage resultMessage=null;
        MemberInformationVO memberInformationVO=new MemberInformationVO("1123", "sng", "song"
        		, 100, null, "1", "1997-5-2", VipType.ConmmentVip.name());
    	resultMessage=usm.addMember(memberInformationVO);
    	
        assertEquals(ResultMessage.success, resultMessage);
    }
    
    
    
    @Test
    public void findTest(){
    	this.linkToServer();
    	MemberInformationVO member=(MemberInformationVO)usm.find("1123", UserType.member);
    	assertNotNull(member);
    	assertEquals(member.getName(),"sng");
    }
    
    
    @Test
    public void getList(){
    	this.linkToServer();
    	ArrayList<UserVO> list=null;
    	list=usm.getAllUsers(UserType.staff);
    	assertEquals(3, list.size());
    }
    
    
    @Test
    public void revokeTester(){
    	ResultMessage reustMessage=null;
    	reustMessage=usm.revoke("1123", memberInformationVO,UserType.member );
    	assertEquals(ResultMessage.success, reustMessage);
    }
    
    @Test
    public void findManagerTest(){
    	ResultMessage resultMessage=ResultMessage.success;
    	assertEquals("summerday", usm.find("1000", UserType.manager).getPassword());
    }
    @Test
    public void findMarketerTest(){
    	ResultMessage resultMessage=ResultMessage.success;
    	assertEquals("jianghaha", usm.find("1000", UserType.marketer).getPassword());
    }
    
    public void linkToServer(){
		final String ip = "localhost";
		try{
			remoteHelper = RemoteHelper.getInstance();
			remoteHelper.setRemote(Naming.lookup("rmi://"+ip+":8888/DateRemoteObject"));
			System.out.println("linked");
		}catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}


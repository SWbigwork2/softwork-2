package UsersTester;

import static org.junit.Assert.*;
import org.junit.Test;

import Usersblimpl.MemberInformationVO;
import Usersblimpl.ResultMessage;
import Usersblimpl.UserControllerblimpl;
import Usersblimpl.UserType;
import Usersblimpl.VipType;

public class MemberTseter {
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
    
    
    
//    @Test
    public void findTest(){
    	MemberInformationVO member=(MemberInformationVO)usm.find("1123", UserType.member);
    	assertNotNull(member);
    	assertEquals(member.getName(),"sng");
    }
    
    
    
    
    
//    @Test
    public void revokeTester(){
    	ResultMessage reustMessage=null;
    	reustMessage=usm.revoke("1123", memberInformationVO,UserType.member );
    	assertEquals(ResultMessage.success, reustMessage);
    }
    
//    @Test
    public void findManagerTest(){
    	ResultMessage resultMessage=ResultMessage.success;
    	assertEquals("summerday", usm.find("1000", UserType.manager).getPassword());
    }
    @Test
    public void findMarketerTest(){
    	ResultMessage resultMessage=ResultMessage.success;
    	assertEquals("jianghaha", usm.find("1000", UserType.marketer).getPassword());
    }
}


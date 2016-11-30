package UsersTester;

import static org.junit.Assert.*;
import org.junit.Test;

import UsersMock.MemberInformationVO;
import UsersMock.ResultMessage;
import UsersMock.UserControllerMock;
import UsersMock.UserType;
import UsersMock.VipType;

public class MemberTseter {
    UserControllerMock usm=new UserControllerMock();
    MemberInformationVO memberInformationVO= new MemberInformationVO("152625", "songjang", "宋江", VipType.ConmmentVip, 100, "1511515151", 1, "1997-02-02");

    @Test
    public void findTest(){
    	MemberInformationVO member=(MemberInformationVO)usm.find("1000", UserType.member);
    	assertNotNull(member);
    	assertEquals(member.getName(),"王华");
    }
    
    
    @Test
    public void addmemberTest(){
        ResultMessage resultMessage=null;
    	resultMessage=usm.addMember("152625", "songjiang", "宋江", VipType.ConmmentVip, 100, "1511515151", 1, "1997-02-02");
        assertEquals(ResultMessage.success, resultMessage);
    }
    
    
    @Test
    public void revokeTester(){
    	ResultMessage reustMessage=null;
    	reustMessage=usm.revoke("152625", memberInformationVO,UserType.member );
    	assertEquals(ResultMessage.success, reustMessage);
    }
}


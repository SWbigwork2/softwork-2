package UsersTester;

import static org.junit.Assert.*;
import org.junit.Test;

import UsersMock.MemberVO;
import UsersMock.ResultMessage;
import UsersMock.UserControllerMock;
import UsersMock.UserType;

public class MemberTseter {
    UserControllerMock usm=new UserControllerMock();
    
    @Tese 
    public void findTest(){
    	MemberVO member=(MemberVO)usm.find(1111, UserType.member);
    	assertNotNull(member);
    	assertEquals(member.getId(),1111);
    }
    
    public void addmemberTest(){
    	assertEquals(usm.addMember(1111, "1234", UserType.member, "xiapming"),ResultMessage.success);
    }
}

package LoginTester;
import static org.junit.Assert.*;

import org.junit.Test;
import java.util.Date;
import LoginMock.LoginControllerMock;
import LoginMock.ResultMessage;
import UsersMock.UserPO;
import UsersMock.UserType;

public class MemberLoginTester {
	LoginControllerMock lcm = new LoginControllerMock(new UserPO("admin", "admin", "admin", UserType.member, "",new Date(1997,05,02)));
	@Test
	public void memeberLoginTest() {
		assertEquals(lcm.loginType[3], 0);
		assertEquals(lcm.login("admin1", "admin", UserType.member), ResultMessage.userNotExit);
		assertEquals(lcm.login("admin", "admin1", UserType.member), ResultMessage.passwordError);
		lcm.login("admin", "admin", UserType.member);
		assertEquals(lcm.getMessage(UserType.member), "admin");
		assertEquals(lcm.loginType[3], 1);
	}
	@Test
	public void memeberLogoutTest(){
		lcm.login("admin", "admin", UserType.member);
		assertEquals(lcm.loginType[3], 1);
		lcm.logout(UserType.member);
		assertEquals(lcm.loginType[3], 0);
	}
	@Test
	public void messageTest(){
		lcm.getMessage(UserType.member);
		assertEquals(lcm.getMessage(UserType.member), null);
		lcm.login("admin", "admin", UserType.member);
		assertEquals(lcm.getMessage(UserType.member), "admin");
	}

}

package LoginTester;
import static org.junit.Assert.*;

import org.junit.Test;

import LoginMock.LoginControllerMock;
import UsersMock.UserType;

public class MemberLoginTester {
	LoginControllerMock lcm = new LoginControllerMock();
	@Test
	public void memeberLoginTest() {
		assertEquals(lcm.loginType[3], 0);
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

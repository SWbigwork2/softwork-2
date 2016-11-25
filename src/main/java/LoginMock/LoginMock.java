package LoginMock;

import po.LoginPO;

public abstract class LoginMock {
	public abstract ResultMessage login(String id,String password);
	public abstract LoginPO getMessage(String id);
		
	

}

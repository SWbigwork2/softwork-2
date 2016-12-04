package loginblimpl;

import po.LoginPO;

public abstract class LoginMock {
	public abstract LoginVo login(String id,String password);
	public abstract LoginPO getMessage(String id);
		
	

}

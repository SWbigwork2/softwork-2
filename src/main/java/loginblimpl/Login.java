package loginblimpl;

import po.LoginPO;

/**
 * @author 朱润之
 * login的抽象父类
 */
public abstract class Login {
	public abstract LoginVo login(String id,String password);
	public abstract LoginPO getMessage(String id);
		
	

}

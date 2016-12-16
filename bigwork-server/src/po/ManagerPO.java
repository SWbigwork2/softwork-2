package po;

import java.io.Serializable;

import Usersblimpl.UserType;

public class ManagerPO extends UserPO implements Serializable{

	public ManagerPO(String i, String n, String p) {
		super(i, n, p, UserType.manager);
		// TODO Auto-generated constructor stub
	}

}

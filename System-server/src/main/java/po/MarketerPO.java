package po;

import java.io.Serializable;

import Usersblimpl.UserType;

public class MarketerPO extends UserPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7097234850826508102L;

	public MarketerPO(String i, String n, String p) {
		super(i, n, p, UserType.marketer);
		// TODO Auto-generated constructor stub
	}
    
}

package po;

import Usersblimpl.UserType;
import Usersblimpl.VipType;

public class MemberInformationPO extends UserPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8655213223816632704L;
	String contactInformation;
	String special;
	double credit;
	int level;
	VipType vipType;
	
	public MemberInformationPO(String i, String n, String p,String contactInformation,double credit,VipType type,String special,int level) {
		super(i, n, p,UserType.member);
        this.contactInformation=contactInformation;
        this.credit=credit;
        this.level=level;
        this.vipType=type;
        this.special=special;
	}
	
	public String getContactInformation() {
		return contactInformation;
	}
	
	public double getCredit() {
		return credit;
	}
	
	public VipType getVipType(){
		return vipType;
	}
	
	public String getSpecial(){
		return special;
	}
	public int getLevel(){
		return level;
	}
	
}

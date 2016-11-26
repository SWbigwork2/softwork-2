package po;


import java.util.Date;

import UsersMock.UserType;

public class MemberInformationPO extends UserPO{
	String contactInformation;
	public String getContactInformation() {
		return contactInformation;
	}
	public double getCredit() {
		return credit;
	}
	public Date getBirthday() {
		return birthday;
	}
	double credit;
	Date birthday;
	public MemberInformationPO(String i, String n, String p,String contactInformation,double credit,Date birthday) {
		super(i, n, p,UserType.member);
        this.contactInformation=contactInformation;
        this.credit=credit;
        this.birthday=birthday;
	}
	
	 
}

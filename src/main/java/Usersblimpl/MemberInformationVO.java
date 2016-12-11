package Usersblimpl;

public class MemberInformationVO extends UserVO{
    
	

	private double credit;
	private String ContactInformation;
	private String level;
	private String  special;
	private String vipType;
	
	
	public MemberInformationVO(String userId, String name, String password, double credit,
			String contactInformation, String level, String special, String vipType) {
		super(userId, name, password, UserType.member.name());
		this.credit = credit;
		ContactInformation = contactInformation;
		this.level = level;
		this.special = special;
		this.vipType = vipType;
	}
	public String getVipType() {
		return vipType;
	}
	public void setVipType(String vipType) {
		this.vipType = vipType;
	}
	public double getCredit() {
		return credit;
	}
	public void setCredit(double credit) {
		this.credit = credit;
	}
	public String getContactInformation() {
		return ContactInformation;
	}
	public void setContactInformation(String contactInformation) {
		ContactInformation = contactInformation;
	}
	
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getSpecial() {
		return special;
	}
	public void setSpecial(String special) {
		this.special = special;
	}
	 
	 
	
	 	 
}

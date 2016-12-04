package Usersblimpl;

public class MemberInformationVO extends UserVO{
    
	

	private double credit;
	private String ContactInformation;
	private int level;
	private String  special;
	 
	 
	public MemberInformationVO(String id,String password,String name,String  viptype
			 ,double credit,String Contactinformation,int level,String special){
		super(id, name, password, UserType.member.name());
        this.ContactInformation=Contactinformation;
        this.level=level;
        this.special=special;
        this.credit=credit;
        this.viptype=viptype;
	}
	 
	 
		public String  getVipType() {
			return viptype;
		}


		public double getCredit() {
			return credit;
		}


		public String getContactInformation() {
			return ContactInformation;
		}


		public int getLevel() {
			return level;
		}


		public String getSpecial() {
			return special;
		}
		private String viptype;
		public String getViptype() {
			return viptype;
		}


		public void setViptype(String viptype) {
			this.viptype = viptype;
		}


		public void setCredit(double credit) {
			this.credit = credit;
		}


		public void setContactInformation(String contactInformation) {
			ContactInformation = contactInformation;
		}


		public void setLevel(int level) {
			this.level = level;
		}


		public void setSpecial(String special) {
			this.special = special;
		}

 
	 	 
}

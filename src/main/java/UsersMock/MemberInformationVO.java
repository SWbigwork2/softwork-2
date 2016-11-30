package UsersMock;

public class MemberInformationVO extends UserVO{
   
	VipType vipType; 
	double credit;
	String ContactInformation;
	int level;
	String  special;
	 
	 
	public MemberInformationVO(String id,String password,String name,VipType vipType
			 ,double credit,String Contactinformation,int level,String special){
		super(id, name, password, UserType.member);
        this.ContactInformation=Contactinformation;
        this.level=level;
        this.special=special;
        this.credit=credit;
        this.vipType=vipType;
	}
	 
	 
		public VipType getVipType() {
			return vipType;
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

 
	 	 
}

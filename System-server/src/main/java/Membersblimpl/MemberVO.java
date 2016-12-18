package Membersblimpl;

public class MemberVO {
	 String id;
	    String password;
	    String name;
	    String telephone;
	    String special;
	    double credit;
	    int type;
	    int level;
	     public MemberVO(String id,String name,String password,String telephone,double credit,String special,int type,int level){
	  	   this.id=id;
	  	   this.name=name;
	  	   this.password=password;
	  	   this.telephone=telephone;
	  	   this.credit =credit;
	  	   this.special=special;
	  	   this.type=type;
	  	   this.level=level;
	     }
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getSpecial() {
			return special;
		}
		public void setSpecial(String special) {
			this.special = special;
		}
		public double getCredit() {
			return credit;
		}
		public void setCredit(double credit) {
			this.credit = credit;
		}
		public int getType() {
			return type;
		}
		public void setType(int type) {
			this.type = type;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
}

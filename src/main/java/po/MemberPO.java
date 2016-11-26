package po;

import java.io.Serializable;
import java.util.Date;

import MembersMock.MembersInfo;

public class MemberPO implements Serializable,MembersInfo{
    String id;
    String password;
    String name;
    String telephone;
    Date birthday;
    double credit;
     public MemberPO(String id,String name,String password,String telephone,double credit,Date birthday){
  	   this.id=id;
  	   this.name=name;
  	   this.password=password;
  	   this.telephone=telephone;
  	   this.credit =credit;
  	   this.birthday=birthday;
     }
     public double getCredit(){
    	 return credit;
     }
     public String getName(){
  	   return name;
     }
	  public String getID(){
		 return id;
	  }
	  public String getPassword(){
		  return password;
	  }
	  public String getTelephone(){
		  return telephone;
	  }
	  public Date getBirthday(){
		  return birthday;
	  }
}
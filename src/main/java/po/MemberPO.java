package po;

import java.io.Serializable;

import Membersblimpl.MembersInfo;

public class MemberPO implements Serializable,MembersInfo{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1678038984150126521L;
	String id;
    String password;
    String name;
    String telephone;
    String special;
    double credit;
    int type;
    int level;
     public MemberPO(String id,String name,String password,String telephone,double credit,String special,int type,int level){
  	   this.id=id;
  	   this.name=name;
  	   this.password=password;
  	   this.telephone=telephone;
  	   this.credit =credit;
  	   this.special=special;
  	   this.type=type;
  	   this.level=level;
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
	  public String getSpecial(){
		  return special;
	  }
	  public int getType(){
		  return type;
	  }
	  public int getLevel(){
		  return level;
	  }
}
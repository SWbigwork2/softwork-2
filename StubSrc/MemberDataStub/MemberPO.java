package MemberDataStub;

import java.io.Serializable;

public class MemberPO implements Serializable {
    String id;
    String password;
    String name;
    String telephone;
     public MemberPO(String i,String n,String p,String t){
  	   id=i;
  	   name=n;
  	   password=p;
  	   telephone=t;
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
}
package MembersMock;



import java.io.Serializable;

public class MemberPO implements Serializable,MembersInfo{
    String id;
    String password;
    String name;
    String telephone;
    double credit;
     public MemberPO(String i,String n,String p,String t,double c){
  	   id=i;
  	   name=n;
  	   password=p;
  	   telephone=t;
  	   credit =c;
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
}